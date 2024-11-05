package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    User getUser(int id);
    void deleteUser(int id);
    void updateUser(User user);
}
