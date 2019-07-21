package com.example.demo00.controller;


import com.example.demo00.service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController implements UserClient {

    @Autowired
    private UserClient userClient;

//    @RequestMapping(value = "hi",method = RequestMethod.GET)
//    public String sayHi(String name){
//        return userClient.home(name);
//    }

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String homess(String name) {
        return userClient.homess(name);
    }
}
