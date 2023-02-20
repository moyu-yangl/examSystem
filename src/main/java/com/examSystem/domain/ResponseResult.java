package com.examSystem.domain;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String Message;
    private T data;

    public ResponseResult() {
        
    }
}
