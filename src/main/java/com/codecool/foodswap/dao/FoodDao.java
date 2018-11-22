package com.codecool.foodswap.dao;

import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;

import java.util.List;

public interface FoodDao {

    void add(Food food);
    void remove(Food food);
    List<Food> getAllFoodByGroup(Group group);


}
