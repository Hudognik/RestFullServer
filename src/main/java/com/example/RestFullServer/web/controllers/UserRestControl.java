package com.example.RestFullServer.web.controllers;

import com.example.RestFullServer.web.model.Role;
import com.example.RestFullServer.web.model.User;
import com.example.RestFullServer.web.service.RoleService;
import com.example.RestFullServer.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping
public class UserRestControl {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/{id}")
    public User getUsers(@PathVariable Long id) {
        return userService.getUserByid(id);
    }

    @GetMapping(value = "/users/get/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return userService.getUserByName(login);
    }

    @GetMapping(value = "/roles/get/{login}")
    public Role getRoleByName(@PathVariable String login) {
        return roleService.getRole(login);
    }

    @GetMapping(value = "/roles/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRole(id);
    }

    @GetMapping(value = "/roles")
    public List<Role> getRoles() {
        return roleService.roleList();
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userService.listUsers();
    }

    @PostMapping(value = "/users/add")
    public User addUser(@RequestBody User user) {
        HashSet<Role> roles = new HashSet<>();
        for (Role r : user.getRoles()) {
            roles.add(roleService.getRole(r.getName()));
        }
        user.setRoles(roles);
        userService.add(user);
        return user;
    }

    @PutMapping(value = "/users/update")
    public User update(@RequestBody User user) {
        HashSet<Role> roles = new HashSet<>();
        for (Role r : user.getRoles()) {
            roles.add(roleService.getRole(r.getName()));
        }
        user.setRoles(roles);
        userService.update(user);
        return user;
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        User user = userService.getUserByid(id);
        userService.delete(user);
        return true;
    }
}