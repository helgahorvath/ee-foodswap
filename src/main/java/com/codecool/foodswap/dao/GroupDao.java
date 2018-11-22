package com.codecool.foodswap.dao;

import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;

public interface GroupDao {

    void add(Group group);
    void remove(Group group);
    void addMemeber(User user);
}
