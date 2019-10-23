package com.spring.service;

import com.spring.model.Role;
import com.spring.model.User;

public interface RoleService {
    Role getRoleByUser(User user);
}
