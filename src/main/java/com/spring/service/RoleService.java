package com.spring.service;

import com.spring.model.Role;
import com.spring.model.User;
import org.springframework.stereotype.Component;

public interface RoleService {
    Role getRoleByUser(User user);
}
