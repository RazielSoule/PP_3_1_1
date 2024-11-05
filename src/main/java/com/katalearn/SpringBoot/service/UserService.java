package com.katalearn.SpringBoot.service;

import com.katalearn.SpringBoot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    User getUser(int id);
    void deleteUser(int id);
    void updateUser(int id, User user);
}
