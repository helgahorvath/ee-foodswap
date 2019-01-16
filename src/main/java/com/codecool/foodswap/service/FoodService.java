package com.codecool.foodswap.service;

import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import com.codecool.foodswap.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public void add(Food food) {
        foodRepository.save(food);
    }

    public void remove(Food food) {
        foodRepository.delete(food);

    }

    public List<Food> getAllFoodByGroup(Group group) {
        return foodRepository.findFoodsByGroup(group);
    }

    public List<Food> getAllFoodByUser(User user) {
        return foodRepository.findFoodsByOwner(user);
    }


}
