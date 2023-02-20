package com.examSystem.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum HttpCodeEnum {
    SUCCESS(200, "操作成功"),
    NEED_LOGIN(401, "需要登录后操作"),
    
    ;


    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
