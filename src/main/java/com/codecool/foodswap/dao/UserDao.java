package com.codecool.foodswap.dao;


import com.codecool.foodswap.model.User;



public interface UserDao {

    void add(User user);
    void remove(User user);
}
