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

    /**
     * 查询用户信息
     *
     * @return
     */
    @GetMapping("/info")
    public ResponseResult getUserInfo() {
        return userService.getUserInfo();
    }

    /**
     * 更新用户信息
     *
     * @param userInfoDto
     * @return
     */
    @PutMapping("/update")
    public ResponseResult updateUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.updateUser(userInfoDto);
    }

    /**
     * 用户注册
     *
     * @param userRegisterDto
     * @return
     */
    @PostMapping("/register")
    public ResponseResult registerUser(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.register(userRegisterDto);
    }

    @GetMapping("/course/publish/students")
    public ResponseResult getAllStudent() {
        return userService.getAllStudent();
    }
}
