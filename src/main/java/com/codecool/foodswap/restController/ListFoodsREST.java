package com.codecool.foodswap.restController;

import com.codecool.foodswap.repositories.FoodRepository;
import com.codecool.foodswap.repositories.GroupRepository;
import com.codecool.foodswap.repositories.UserRepository;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;

public class ListFoodsREST {

    private GroupRepository groupRepository;
    private FoodRepository foodRepository;


    public ListFoodsREST(GroupRepository groupRepository, FoodRepository foodRepository) {
        this.groupRepository = groupRepository;
        this.foodRepository = foodRepository;
    }

    @GetMapping("/{userId}")
    public JSONObject listFoods() {
        //TODO
    }
}
