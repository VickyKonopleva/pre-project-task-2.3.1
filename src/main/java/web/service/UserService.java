package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
//    void createUsersTable();
//
//    void dropUsersTable();
    void update(int id, User user);
    void saveUser(User user);
    User show(int id);

    void delete(int id);

    List<User> getAllUsers();

//    void cleanUsersTable();
}
