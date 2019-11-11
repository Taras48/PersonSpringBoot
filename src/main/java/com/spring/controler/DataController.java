package com.spring.controler;

import com.spring.model.User;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
/*@RequestMapping("/admin")*/
public class DataController {

    private UserService service;
    private RoleService roleService;

    @Autowired
    public DataController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        List<User> list = service.findAll();
        return list;
    }

    //@PostMapping(value = "/admin/add")
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public void postAdd(@RequestParam User name) {
        /*User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setMessage(request.getParameter("message"));
       user.setRoles(roleService.findAllByRole(request.getParameter("role")));*/
        //service.saveUser(user);
        System.err.println(name);
        // return name;
    }

    @PutMapping(value = "/update")
    public void putUpdateUser(@RequestBody User user, @RequestBody String role) {
        User upUser = service.getUserById(user.getId());
        upUser.setName(user.getName());
        upUser.setPassword(user.getPassword());
        upUser.setRoles(roleService.findAllByRoleIsContaining(role));
        upUser.setMessage(user.getMessage());
        service.updateUser(upUser);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestBody Long id) {
        service.deleteUser(id);
    }
}
