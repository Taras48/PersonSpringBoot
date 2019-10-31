package com.spring.controler;

import com.spring.model.Role;
import com.spring.model.User;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    private UserService service;
    private RoleService roleService;

    @Autowired
    public MainController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;

    }

    @GetMapping(value = "/login")
    public String getLogin() {
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;*/
        return "/login";
    }

    //userGetMapping
    @GetMapping(value = "/user")
    public String getUserPage() {
        return "/user";
    }

    //adminPostMapping
    @PostMapping(value = "/admin/add")
    public ModelAndView postAdd(User user, ModelAndView modelAndView, String role) {
        user.setRoles(roleService.findAllByRole(role));
        service.saveUser(user);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @PostMapping(value = "/admin/update")
    public ModelAndView postUpdate(User user, ModelAndView modelAndView, String role) {
        User upUser = service.getUserById(user.getId());
        upUser.setName(user.getName());
        upUser.setPassword(user.getPassword());
        upUser.setRoles(roleService.findAllByRoleIsContaining(role));
        upUser.setMessage(user.getMessage());
        service.saveUser(user);
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
    public String getAdd() {
        return "admin/addUser";
    }

    @GetMapping(value = "/admin")
    public ModelAndView allUsers(ModelAndView modelAndView) {
        modelAndView.addObject("list", service.findAll());
        modelAndView.setViewName("admin/allUser");
        return modelAndView;
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
