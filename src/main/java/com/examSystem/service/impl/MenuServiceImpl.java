package com.examSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.entity.Menu;
import com.examSystem.mapper.MenuMapper;
import com.examSystem.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

