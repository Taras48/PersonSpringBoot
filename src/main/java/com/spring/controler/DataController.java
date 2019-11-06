package com.spring.controler;

import com.spring.model.User;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class DataController {

    private UserService service;
    private RoleService roleService;

    @Autowired
    public DataController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping(value = "/all")
    public List<User> getAllUsers(){
        List<User> list = service.findAll();
        return list;
    }

    @PostMapping(value = "/add")
    public void postAdd(@RequestBody User user,@RequestBody String role){
        user.setRoles(roleService.findAllByRole(role));
        service.saveUser(user);
    }

    @PutMapping(value = "/update")
    public void putUpdateUser(@RequestBody User user,@RequestBody String role){
        User upUser = service.getUserById(user.getId());
        upUser.setName(user.getName());
        upUser.setPassword(user.getPassword());
        upUser.setRoles(roleService.findAllByRoleIsContaining(role));
        upUser.setMessage(user.getMessage());
        service.updateUser(upUser);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestBody Long id){
        service.deleteUser(id);
    }
}
