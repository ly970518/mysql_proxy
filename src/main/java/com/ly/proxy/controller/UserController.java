package com.ly.proxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ly.proxy.domain.User;
import com.ly.proxy.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> userList() {
        return userService.listUser();
    }

    @RequestMapping("/update")
    public int update() {
        return userService.update();
    }
}
