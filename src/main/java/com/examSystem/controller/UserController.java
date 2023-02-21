package com.examSystem.controller;

import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.UserInfoDto;
import com.examSystem.domain.dot.UserRegisterDto;
import com.examSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/info")
    public ResponseResult getUserInfo() {
        return userService.getUserInfo();
    }

    @PutMapping("/user/update")
    public ResponseResult updateUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.updateUser(userInfoDto);
    }

    @PostMapping("/user/register")
    public ResponseResult registerUser(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.register(userRegisterDto);
    }
}