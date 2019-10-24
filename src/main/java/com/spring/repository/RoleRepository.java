package com.spring.repository;

import com.spring.model.Role;
import com.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findAllByRole(String role);
    Role findAllByRoleIsContaining(String role);
}