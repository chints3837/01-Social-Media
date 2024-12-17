package com.example.socialmedia.controller;

import com.example.socialmedia.entity.UserInfo;
import com.example.socialmedia.serviceImpl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoServiceImpl userService;

    @PostMapping("/addUser")
    public UserInfo addUser(@RequestBody UserInfo userInfo) {
        return userService.addUser(userInfo);
    }
}
