package com.xu.controller;

import com.xu.domain.User;
import com.xu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    UserService userService;


    @RequestMapping("/test")
    public String test(){
        userService.saveAllUser();
        return "ok";
    }

    @RequestMapping("/testSql")
    public Object testSql(){
        List<User> users = userService.emSave();
        return users;
    }

}
