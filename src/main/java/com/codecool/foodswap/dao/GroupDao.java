package com.codecool.foodswap.dao;

import com.codecool.foodswap.model.Group;

public interface GroupDao {

    void add(Group group);
    void remove(Group group);
    Group findByName(String name);

}
