package com.codecool.foodswap.dao;

import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;

import java.util.List;

public interface GroupDao {

    void add(Group group);
    void remove(Group group);
    List<Group> findByName(String name);
    void addUserToGroup(User user, Group group);
    Group findById(int Id);

}
