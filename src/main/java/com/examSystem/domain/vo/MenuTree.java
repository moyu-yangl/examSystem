package com.examSystem.domain.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuTree {
    @TableId
    private Long menuId;

    //权限菜单名称
    private String menuName;
    //父菜单id
    private Long parentId;
    //子菜单
    private String component;
    //路径
    private String path;
    //菜单类型
    private String type;
    //状态 0是启用 1是关闭
    private String state;
    //路由地址
    private String perms = "";
    //图标
    private String icon;

    private List<MenuTree> children;
}
