package com.example.RestFullServer.web.dao;

import com.example.RestFullServer.web.model.User;

import java.util.List;

public interface UserDao {
    Long add(User user);
    List<User> listUsers();
    void delete(User user);
    void update(User user);


    User findById(Long id);

    User findByUsername(String username);
}
