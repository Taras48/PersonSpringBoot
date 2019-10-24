package com.spring.service;

import com.spring.model.Role;
import com.spring.model.User;
import com.spring.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByUser(User user) {
        return roleRepository.getRoleByUser(user);
    }
}
