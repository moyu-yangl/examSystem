package com.examSystem.domain.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVo {

    //用户id
    @TableId
    private Long userId;
    //用户名
    private String name;
    //性别（男0 女1 未知2）
    private String sex;
    //手机号
    private String phonenumber;
    //学院
    private String college;
    //角色id，默认是学生
    private String role;
    //头像
    private String avatar;
}
