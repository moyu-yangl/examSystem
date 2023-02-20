package com.examSystem.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户角色表(UserRole)表实体类
 *
 * @author makejava
 * @since 2023-02-20 10:22:56
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_role")
public class UserRole {

    //用户id
    private Long userId;
    //角色id
    private Long roleId;
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

