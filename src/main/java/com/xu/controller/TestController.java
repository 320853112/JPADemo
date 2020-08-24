package com.xu.controller;

import com.xu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserService userService;


    @RequestMapping("/test")
    public String test(){
        userService.saveAllUser();
        return "ok";
    }
}
