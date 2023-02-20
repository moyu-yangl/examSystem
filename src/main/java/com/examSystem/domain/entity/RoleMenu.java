package com.examSystem.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 角色菜单表(RoleMenu)表实体类
 *
 * @author makejava
 * @since 2023-02-20 10:22:55
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role_menu")
public class RoleMenu {

    //角色id
    private Long roleId;
    //权限菜单id
    private Long menuId;
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

