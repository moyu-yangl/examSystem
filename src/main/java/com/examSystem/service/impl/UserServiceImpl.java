package com.examSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.entity.LoginUser;
import com.examSystem.domain.entity.User;
import com.examSystem.enums.HttpCodeEnum;
import com.examSystem.mapper.UserMapper;
import com.examSystem.service.UserService;
import com.examSystem.utils.JwtUtil;
import com.examSystem.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-02-21 09:10:43
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(Long userId, String password) {
        //账号或密码为空
        if (Objects.isNull(userId) || !StringUtils.hasText(password)) {
            return ResponseResult.errorResult(HttpCodeEnum.ID_OR_PASSWORD_IS_NULL);
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("认证失败");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId2 = loginUser.getUser().getUserId().toString();
        String token = JwtUtil.createJWT(userId2);
        redisCache.setCacheObject("loginUser:" + userId2, loginUser);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return ResponseResult.okResult(map);
    }
}

