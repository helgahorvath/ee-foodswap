package com.codecool.foodswap.repositories;

import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findFoodsByGroup(Group group);

    List<Food> findFoodsByDietTypes(DietType dietType);

    List<Food> findFoodsByNameContaining(String name);
}
