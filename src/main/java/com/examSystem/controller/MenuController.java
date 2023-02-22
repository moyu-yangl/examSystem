package com.examSystem.controller;

import com.examSystem.domain.ResponseResult;
import com.examSystem.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询用户路由查询
     *
     * @return
     */
    @GetMapping("/getRouters")
    public ResponseResult getRouters() {
        return menuService.getRouters();
    }
}
