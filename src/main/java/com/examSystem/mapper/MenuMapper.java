package com.examSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examSystem.domain.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectAllByUserId(Long userId);
}
