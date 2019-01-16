package com.codecool.foodswap.restController;

import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.User;
import com.codecool.foodswap.service.FoodService;
import com.codecool.foodswap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListFoodsREST {


    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @GetMapping("/get-food-by-user/{userId}")
    public List<Food> listFoodsByUser(@PathVariable String userId) {
        User user = userService.getUserById(Integer.parseInt(userId));
        return foodService.getAllFoodByUser(user);
    }
}
