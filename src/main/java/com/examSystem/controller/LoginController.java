package com.examSystem.controller;

import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.UserDto;
import com.examSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody UserDto user) {
        return userService.login(Long.valueOf(user.getUserId()), user.getPassword());
    }
}
