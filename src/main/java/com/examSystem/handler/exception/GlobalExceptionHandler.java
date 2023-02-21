package com.examSystem.handler.exception;

import com.examSystem.domain.ResponseResult;
import com.examSystem.enums.HttpCodeEnum;
import com.examSystem.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SystemException.class)
    public ResponseResult systemExceptionHandler(SystemException e) {
        return ResponseResult.errorResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e) {
        return ResponseResult.errorResult(HttpCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }
}
