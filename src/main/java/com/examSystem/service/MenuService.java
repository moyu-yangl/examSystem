package com.examSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examSystem.domain.entity.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {
    List<String> listPermsByUserid(Long userId);
}
