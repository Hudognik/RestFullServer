package com.example.RestFullServer.web.service;

import com.example.RestFullServer.web.dao.RoleDao;
import com.example.RestFullServer.web.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;


    public List<Role> roleList() {
        return roleDao.roleList();
    }

    public Role getRole(Long id) {
        return roleDao.getRoleById(id);
    }

    public Role getRole(String name) {
        return roleDao.getRoleByName(name);
    }
}
