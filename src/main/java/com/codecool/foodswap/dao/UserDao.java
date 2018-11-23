package com.codecool.foodswap.dao;

import com.codecool.foodswap.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    void remove(User user);
    int verifyUser(String email, String password);
    void joinGroup(User user);
}
