package com.examSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.entity.Menu;
import com.examSystem.domain.vo.MenuTree;
import com.examSystem.mapper.MenuMapper;
import com.examSystem.service.MenuService;
import com.examSystem.utils.BeanCopyUtils;
import com.examSystem.utils.SecurityContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限菜单表(Menu)表服务实现类
 *
 * @author makejava
 * @since 2023-02-21 09:09:29
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<String> listPermsByUserid(Long userId) {
        return menuMapper.selectAllByUserId(userId);
    }

    @Override
    public ResponseResult getRouters() {
        Long userId = SecurityContextUtils.getUserId();
        List<Menu> menus = menuMapper.selectMenuListByUserId(userId);
        List<MenuTree> menuTrees = BeanCopyUtils.copyBeanList(menus, MenuTree.class);
        List<MenuTree> menuTree = getMenuTree(menuTrees, 0L);
        Map<String, Object> map = new HashMap<>();
        map.put("routers", menuTree);

        return ResponseResult.okResult(map);
    }

    private List<MenuTree> getMenuTree(List<MenuTree> list, Long parentId) {
        List<MenuTree> menuTree = new ArrayList<>();
        for (MenuTree m : list) {
            if (m.getParentId().equals(parentId)) {
                List<MenuTree> children = new ArrayList<>();
                for (MenuTree child : list) {
                    if (child.getParentId().equals(m.getMenuId())) {
                        children.add(child);
                    }
                }
                m.setChildren(children);
                menuTree.add(m);
            }
        }
        return menuTree;
    }

}

