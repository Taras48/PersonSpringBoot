package com.spring.repository;

import com.spring.model.Role;
import com.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByUser(User user);
}
