package com.examSystem.mapper;

import com.examSystem.domain.entity.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> selectAllByUserId(Long userId);
}
