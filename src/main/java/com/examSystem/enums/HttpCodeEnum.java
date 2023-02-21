package com.examSystem.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum HttpCodeEnum {
    SUCCESS(200, "操作成功"),
    NEED_LOGIN(401, "需要登录后操作"),
    ID_OR_PASSWORD_IS_NULL(402, "账户或密码为空"),
    NO_PERMISSIONS(403, "没有权限进行操作"),

    SYSTEM_ERROR(500, "系统异常"),
    LOGIN_ERROR(505, "账号或密码错误"),

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
