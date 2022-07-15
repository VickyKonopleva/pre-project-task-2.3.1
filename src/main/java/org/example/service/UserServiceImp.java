package org.example.service;

import org.springframework.stereotype.Service;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImp;
import org.example.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    UserDao userDao = new UserDaoImp();
    @Override
    public void update(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
