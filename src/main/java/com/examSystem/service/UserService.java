package com.examSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.UserInfoDto;
import com.examSystem.domain.dot.UserRegisterDto;
import com.examSystem.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User> {


    ResponseResult login(Long userId, String password);

    ResponseResult logout();

    ResponseResult getUserInfo();

    ResponseResult updateUser(UserInfoDto userInfoDto);

    ResponseResult register(UserRegisterDto userRegisterDto);

    String getNameByUserId(Long studentId);

    ResponseResult getAllStudent();
    
}
