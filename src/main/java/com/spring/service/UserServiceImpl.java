package com.spring.service;

import com.spring.model.User;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
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
        repository.save(user);

    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
