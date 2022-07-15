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
        TypedQuery<User> typedQuery = em.createQuery("select a from User a", User.class);
        return  typedQuery.getResultList();
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
        em.remove(show(id));
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        User updatedUser;
        updatedUser = show(id);
        em.detach(updatedUser);
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
        em.merge(updatedUser);
    }
}
