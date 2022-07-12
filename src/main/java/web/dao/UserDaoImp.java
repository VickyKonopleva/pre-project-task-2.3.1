package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;



    public List<User>  getAllUsers() {
        TypedQuery<User> typedQuery = entityManager.createQuery("Select User from User", User.class);
        return  typedQuery.getResultList();
    }



    @Override
    public void saveUser(User user) {
        String qlString = "insert into User (name,surname) values (?,?)";
        Query query = entityManager.createNativeQuery(qlString);
        query.setParameter(1, user.getName());
        query.setParameter(2, user.getSurname());
        query.executeUpdate();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        String qlString = "delete from User where iduser=?";
        Query query = entityManager.createNativeQuery(qlString);
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Override
    public void updateUser(int id, User user) {
        String query= "update User set name = ? and surname = ? where id = ?";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter(1, user.getName());
        nativeQuery.setParameter(2, user.getSurname());
        nativeQuery.setParameter(3, user.getId());
        nativeQuery.executeUpdate();
    }




}
