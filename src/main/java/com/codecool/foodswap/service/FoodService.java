package com.codecool.foodswap.service;

import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.repositories.FoodRepository;
import com.codecool.foodswap.representation.FoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public void add(Food food) {
        foodRepository.save(food);
    }

    public void remove(Food food) {
        foodRepository.delete(food);

    }
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public List<Food> getAllFoodByGroup(Group group) {
        return foodRepository.findFoodsByGroup(group);
    }

    public List<Food> getFoodByDietType(DietType diettype) {
        return foodRepository.findFoodsByDietTypes(diettype);
    }


    public List<FoodDTO> foodsByGroup (Group group) {
        List<FoodDTO> foodDTO = new ArrayList<>();

        for(Food food : getAllFoodByGroup(group)) {
            FoodDTO foodDTOs = new FoodDTO(food.getName(),food.getDescription(),food.getFoodIMG(),food.getDietTypes(),food.getExpDate(),food.getOwner().getId());
            foodDTO.add(foodDTOs);
        }
        return foodDTO;
    }

    public List<FoodDTO> getFoodByDietTypes(DietType diettype) {
        List<FoodDTO> foodList = new ArrayList<>();
        for (Food food : getFoodByDietType(diettype)) {
             FoodDTO foodDTO = new FoodDTO(food.getName(),food.getDescription(),food.getFoodIMG(),food.getDietTypes(),food.getExpDate(),food.getOwner().getId());
             foodList.add(foodDTO);
        }
        return foodList;
    }


    public List<FoodDTO> getFoodByName(String name) {
        List<FoodDTO> foodDTOS = new ArrayList<>();

        for (Food food : foodRepository.findFoodsByNameContaining(name)) {
            FoodDTO foodDTO = new FoodDTO(food.getName(),food.getDescription(),food.getFoodIMG(),food.getDietTypes(),food.getExpDate(),food.getOwner().getId());
            foodDTOS.add(foodDTO);
        }
        return foodDTOS;
    }


    public void updateFood(String name ,Long id) {
        Food food = foodRepository.findById(id).get();
        food.setName(name);
        foodRepository.save(food);

    }


    public void deleteFood(Long id) {
       foodRepository.deleteById(id);
    }






}
