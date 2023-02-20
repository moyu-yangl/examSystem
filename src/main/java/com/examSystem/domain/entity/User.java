package com.examSystem.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-02-20 10:22:55
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    //用户id@TableId
    private Long userId;

    //密码
    private String password;
    //用户名
    private String name;
    //性别（男0 女1 未知2）
    private String sex;
    //手机号
    private String phonenumber;
    //学院
    private String college;
    //角色id，默认是学生
    private Long roleId;
    //用户状态，1为关闭用户
    private String state;
    //头像
    private String avatar;
    //创建时间
    private Date createTime;
    //创建人
    private Long createBy;
    //更新人
    private Long updateBy;
    //更新时间
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;


}

