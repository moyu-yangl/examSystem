package com.examSystem.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examSystem.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User> {
}
