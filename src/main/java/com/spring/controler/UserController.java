package com.spring.controler;

import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    private UserService service;
    private RoleService roleService;

    @Autowired
    public UserController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    //userGetMapping
    @GetMapping(value = "/user")
    public String getUserPage() {
        return "user";
    }

    //adminGetMapping
    @GetMapping(value = "/admin/add")
    public String getAdd() {
        return "admin/addUser";
    }

    @GetMapping(value = "/admin")
    public String allUsers() {
        return "admin/allUser";
    }

    @GetMapping(value = "/admin/update")
    public String updateUsers() {
        return "admin/updateUser";
    }

    @GetMapping(value = "/admin/delete")
    public String deleteUsers() {
        return "admin/deleteUser";
    }
}
