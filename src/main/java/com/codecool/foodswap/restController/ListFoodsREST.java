package com.codecool.foodswap.restController;

import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.repositories.FoodRepository;
import com.codecool.foodswap.repositories.GroupRepository;
import com.codecool.foodswap.repositories.UserRepository;
import com.codecool.foodswap.representation.FoodDTO;
import com.codecool.foodswap.service.FoodService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListFoodsREST {

    private FoodService foodService;

    public ListFoodsREST(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/list_foods/{userId}")
    public JSONObject listFoods() {
        //TODO
        return new JSONObject("{'dddd':234}");
    }

    @GetMapping("/get-food-by-diet-type")
    public List<FoodDTO> foodsByDietType(@RequestParam String dietTypes) {
        return foodService.getFoodByDietTypes(DietType.valueOf(dietTypes.toUpperCase()));
    }


    @GetMapping("/search")
    public List<FoodDTO> foodsByName(@RequestParam String name) {
        return foodService.getFoodByName(name);
    }


    @PutMapping("/update/{id}")
    public void updateFoodNameById(@RequestParam("name") String name, @PathVariable("id") long foodId){
        foodService.updateFood(name,foodId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFoodById(@PathVariable("id") long foodId) {
        foodService.deleteFood(foodId);
    }
}
