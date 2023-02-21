package com.examSystem.service.impl;

import com.examSystem.domain.entity.LoginUser;
import com.examSystem.domain.entity.User;
import com.examSystem.service.MenuService;
import com.examSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Long userId = Long.valueOf(username);
        User user = userService.getById(userId);

        if (user == null) {
            throw new UsernameNotFoundException("用户未找到");
        }
        // TODO 权限查询
        List<String> menuList = menuService.listPermsByUserid(user.getUserId());
        LoginUser loginUser = new LoginUser(user, menuList);
        return loginUser;
    }
}
