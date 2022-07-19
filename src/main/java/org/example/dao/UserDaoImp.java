package org.example.dao;


import org.example.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<User>  getAllUsers() {
        return  em.createQuery("select a from User a", User.class).getResultList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        em.persist(user);
    }
    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        em.createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }
}
