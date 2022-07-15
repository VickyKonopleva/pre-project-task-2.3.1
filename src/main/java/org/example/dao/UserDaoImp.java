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
        TypedQuery<User> typedQuery = em.createQuery("Select User from User", User.class);
        return  typedQuery.getResultList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        String qlString = "insert into User (name,surname) values (?,?)";
        Query query = em.createNativeQuery(qlString);
        query.setParameter(1, user.getName());
        query.setParameter(2, user.getSurname());
        query.executeUpdate();
    }
    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        String qlString = "delete from User where id=?";
        Query query = em.createNativeQuery(qlString);
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        String query= "update User set name = ? and surname = ? where id = ?";
        Query nativeQuery = em.createNativeQuery(query);
        nativeQuery.setParameter(1, user.getName());
        nativeQuery.setParameter(2, user.getSurname());
        nativeQuery.setParameter(3, user.getId());
        nativeQuery.executeUpdate();
    }




}
