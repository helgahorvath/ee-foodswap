package com.codecool.foodswap.repositories;

import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {

    List<Food> findFoodsByGroup(Group group);
    List<Food> findFoodsByOwner(User user);

    List<Food> findFoodsByDietTypes(DietType dietType);

    List<Food> findFoodsByNameContaining(String name);

}
