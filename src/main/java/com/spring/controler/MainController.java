package com.spring.controler;

import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private UserService service;

    @Autowired
    public MainController(UserService service){
        this.service = service;
    }

    @GetMapping
    public String getLogin(){
        return "login";
    }
}
