package com.codecool.foodswap.dao;

import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;

public interface GroupDao {

    void add(Group group);
    void remove(Group group);
    Group findByName(String name);
    void addUserToGroup(User user, Group group);

}
