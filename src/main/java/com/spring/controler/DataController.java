package com.spring.controler;

import com.spring.model.JsonUser;
import com.spring.model.User;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public @ResponseBody
    List<User> getAllUsers() {
        List<User> list = service.findAll();
       /* ModelAndView model = new ModelAndView();
        model.addObject("list",list);*/
        // return new ResponseEntity(list, HttpStatus.OK);
        return list;
    }

    @PostMapping(value = "/add")
    public void postAdd(@RequestBody JsonUser jsonUser) {
        User user = new User();
        user.setName(jsonUser.getName());
        user.setPassword(jsonUser.getPassword());
        user.setMessage(jsonUser.getMessage());
        user.setRoles(roleService.findAllByRole(jsonUser.getRole()));
        service.saveUser(user);
    }

    @PutMapping(value = "/update")
    public void putUpdateUser(@RequestBody JsonUser jsonUser) {
        User upUser = service.getUserById(jsonUser.getId());
        upUser.setName(jsonUser.getName());
        upUser.setPassword(jsonUser.getPassword());
        upUser.setRoles(roleService.findAllByRoleIsContaining(jsonUser.getRole()));
        upUser.setMessage(jsonUser.getMessage());
        service.updateUser(upUser);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestBody Long id) {
        service.deleteUser(id);
    }
}
