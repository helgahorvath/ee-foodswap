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

    private GroupRepository groupRepository;
    private FoodRepository foodRepository;
    private FoodService foodService;

    public ListFoodsREST(GroupRepository groupRepository, FoodRepository foodRepository, FoodService foodService) {
        this.groupRepository = groupRepository;
        this.foodRepository = foodRepository;
        this.foodService = foodService;
    }

    @GetMapping("/list_foods/{userId}")
    public JSONObject listFoods() {
        //TODO
        return new JSONObject("{'dddd':234}");
    }

    @GetMapping(value = "/get_food_by_diet_type")
    public List<FoodDTO> foodsByDietType(@RequestParam String dietTypes) {
        System.out.println(dietTypes);
        DietType dietType1 = DietType.LACTOSEFREE;
        return foodService.getFoodByDietTypes(dietType1);
    }
}
