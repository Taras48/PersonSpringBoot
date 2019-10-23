package com.spring.service;

import com.spring.model.User;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository repository;


    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public User getUserById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User upUser = repository.getOne(user.getId());
        upUser.setName(user.getName());
        upUser.setPassword(user.getPassword());
        upUser.setRoles(user.getRoles());
        upUser.setMessage(user.getMessage());
        repository.save(upUser);

    }

    @Override
    public void deleteUser(Long id) {
        //repository.delete(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
