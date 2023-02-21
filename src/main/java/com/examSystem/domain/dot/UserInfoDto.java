package com.examSystem.domain.dot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    //用户名
    private String name;
    //性别（男0 女1 未知2）
    private String sex;
    //手机号
    private String phonenumber;
    //学院
    private String college;


}
