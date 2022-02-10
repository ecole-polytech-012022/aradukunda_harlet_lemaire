package com.polytech.Quiz_me.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.polytech.Quiz_me.model.User;
import com.polytech.Quiz_me.repository.UserRepository;

@Service
public class UserService {
    
    public List<User> list = new ArrayList<>();
    public Integer id = 1;

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public User getUserById(Integer id) {

        Optional<User> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    public User createUser(User givenUser) {

        if (givenUser.getPseudo() != null) {
            return this.repository.save(givenUser);
        }
        return null;
    }

    public boolean deleteUser(Integer userId) {
        User found = getUserById(userId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }
}