package com.codecool.foodswap.dao;

import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    void remove(User user);
    int verifyUser(String email, String password);
    void joinGroup(User user, Group group);
    void addDietTypes(User user, List<DietType> dietTypes);
}
