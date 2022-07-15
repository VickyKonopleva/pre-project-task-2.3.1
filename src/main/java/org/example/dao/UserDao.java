package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {
//    void createUsersTable();
//
//    void dropUsersTable();

    void saveUser(User user);
    User show(int id);
//
    void delete(int id);

    void updateUser(int id, User user);

    List<User> getAllUsers();

//    void cleanUsersTable();
}
