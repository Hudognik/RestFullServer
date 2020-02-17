package com.example.RestFullServer.web.dao;


import com.example.RestFullServer.web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Long add(User user) {
       Long id  = (Long) sessionFactory.getCurrentSession().save(user);
       return id;
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public User findById(Long id) {
        User user = (User) sessionFactory.getCurrentSession().createQuery("FROM User where id=:id").setParameter("id", id).getSingleResult();
        return user;
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        User user = (User) sessionFactory.getCurrentSession().createQuery("FROM User where firstName=:name").setParameter("name", username).getSingleResult();
        return user;
    }
}
