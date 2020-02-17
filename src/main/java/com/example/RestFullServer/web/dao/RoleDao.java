package com.example.RestFullServer.web.dao;

import com.example.RestFullServer.web.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Role getRoleById(Long id) {
        Role role = (Role) sessionFactory.getCurrentSession().createQuery("FROM Role where id=:id").setParameter("id", id).getSingleResult();
        return role;
    }

    @Transactional
    public Role getRoleByName(String name) {
        Role role = (Role) sessionFactory.getCurrentSession().createQuery("from Role where name = :name").setParameter("name", name).getSingleResult();
        return role;
    }

    @Transactional
    public List<Role> roleList() {
        return sessionFactory.getCurrentSession().createQuery("from Role").list();
    }

}
