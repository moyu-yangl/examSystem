package com.common.handler.security;

import com.alibaba.fastjson.JSON;
import com.common.core.ResponseResult;
import com.common.enums.HttpCodeEnum;
import com.common.utils.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        authException.printStackTrace();
        ResponseResult result;
        if (authException instanceof BadCredentialsException) {
            result = ResponseResult.errorResult(HttpCodeEnum.LOGIN_ERROR.getCode(), authException.getMessage());
        } else if (authException instanceof InsufficientAuthenticationException) {
            result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
        } else {
            result = ResponseResult.errorResult(HttpCodeEnum.SYSTEM_ERROR.getCode(), "认证或授权失败");
        }
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
