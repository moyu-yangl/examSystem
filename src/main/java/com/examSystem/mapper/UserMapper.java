package com.examSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examSystem.domain.entity.User;

public interface UserMapper extends BaseMapper<User> {
    String getRoleById(Long userId);
}
