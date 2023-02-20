package com.examSystem.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 权限菜单表(Menu)表实体类
 *
 * @author makejava
 * @since 2023-02-20 10:22:55
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("menu")
public class Menu {
    //权限菜单id@TableId
    private Long menuId;

    //权限菜单名称
    private String menuName;
    //父菜单id
    private Long parentId;
    //子菜单
    private Long childrenId;
    //路径
    private String path;
    //菜单类型
    private String type;
    //状态 0是启用 1是关闭
    private String state;
    //路由地址
    private String perms;
    //图标
    private String icon;
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

