package com.codecool.foodswap.restController;

import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UploadFoodRest {

    @Autowired
    private FoodService foodService;


    public void addFood(Food food) {
        foodService.add(food);
    }

    @PostMapping("/uploadfood")
    public void addFoodForm(@RequestBody Food food) {
        addFood(food);
    }

}
