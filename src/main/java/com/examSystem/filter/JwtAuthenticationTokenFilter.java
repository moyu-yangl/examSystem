package com.examSystem.filter;

import com.alibaba.fastjson.JSON;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.entity.LoginUser;
import com.examSystem.enums.HttpCodeEnum;
import com.examSystem.utils.JwtUtil;
import com.examSystem.utils.RedisCache;
import com.examSystem.utils.WebUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //1. 获取请求头中的token
        String token = httpServletRequest.getHeader("token");
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        String userID;
        try {
            //2. 解析token得到userid
            Claims claims = JwtUtil.parseJWT(token);
            userID = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            ResponseResult result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
            return;
        }


        // 如果token错误或者已经过期 则userId为空
        if (!StringUtils.hasText(userID)) {
            ResponseResult response = new ResponseResult();
            //TODO 写入返回响应   需要登录
            ResponseResult result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
            return;
        }

        //3. 从redis查询user
        LoginUser user = redisCache.getCacheObject("loginUser:" + userID);

        // 如果token没过期而redis中过期则user为空
        if (Objects.isNull(user)) {
            ResponseResult response = new ResponseResult();
            //TODO 写入返回响应   需要登录
            ResponseResult result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
            return;
        }

        //4. 存入contextHolder
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, null);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
