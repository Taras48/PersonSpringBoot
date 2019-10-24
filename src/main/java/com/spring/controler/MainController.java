package com.spring.controler;

import com.spring.model.User;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    private UserService service;
    private RoleService roleService;

    @Autowired
    public MainController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;

    }

    @GetMapping
    public String getLogin() {
        return "login";
    }

    //adminPostMapping
    @PostMapping(value = "/admin/add")
    public ModelAndView postAdd(User user, ModelAndView modelAndView) {
        service.saveUser(user);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @PostMapping(value = "/admin/update")
    public ModelAndView postUpdate(User user, ModelAndView modelAndView) {
        user.setRoles(roleService.getRoleByUser(user));
        service.updateUser(user);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @PostMapping(value = "/admin/delete")
    public ModelAndView postDelete(Long id, ModelAndView modelAndView) {
        service.deleteUser(id);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    //adminGetMapping
    @GetMapping(value = "/admin/add")
    public ModelAndView getAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/addUser");
        return modelAndView;
    }

    @GetMapping(value = "/admin")
    public ModelAndView allUsers(ModelAndView modelAndView) {
       // modelAndView.addObject("listUsers", service.findAll());
        modelAndView.setViewName("admin/allUser");
        return modelAndView;
    }

    @GetMapping(value = "/admin/update")
    public ModelAndView updateUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/updateUser");
        return modelAndView;
    }

    @GetMapping(value = "/admin/delete")
    public ModelAndView deleteUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/deleteUser");
        return modelAndView;
    }
}
