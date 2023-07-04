package com.common.core;

import com.common.enums.HttpCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public ResponseResult() {
        this.code = HttpCodeEnum.SUCCESS.getCode();
        this.message = HttpCodeEnum.SUCCESS.getMsg();
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static ResponseResult errorResult(HttpCodeEnum enums) {
        return new ResponseResult(enums.getCode(), enums.getMsg());
    }

    public static ResponseResult errorResult(Integer code, String msg) {
        return new ResponseResult(code, msg);
    }

    public static ResponseResult okResult() {
        return new ResponseResult();
    }

    public static ResponseResult okResult(Integer code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, null, msg);
    }

    public static ResponseResult okResult(Object data) {
        ResponseResult result = new ResponseResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getMsg());
        if (result != null) {
            result.setData(data);
        }
        return result;
    }

    public ResponseResult<?> error(Integer code, String msg) {
        this.code = code;
        this.message = msg;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.message = msg;
        return this;
    }
}
