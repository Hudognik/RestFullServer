package com.example.RestFullServer.web.service;

import com.example.RestFullServer.web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    void delete(User user);

    void update(User user);

    User getUserByName(String username);

    User getUserByid(Long id);
}
