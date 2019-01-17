package com.codecool.foodswap.restController;

import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.representation.FoodDTO;
import com.codecool.foodswap.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codecool.foodswap.representation.GroupDTO;
import com.codecool.foodswap.service.UserService;
import com.codecool.foodswap.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;
import java.util.*;

@Component
@Scope("session")
@RestController
public class ListFoodsREST {


    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private GroupDTO groupDTO;


    public ListFoodsREST() {
    }

    public ListFoodsREST(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/get-food-by-diet-type")
    public List<FoodDTO> foodsByDietType(@RequestParam String dietTypes) {
        return foodService.getFoodByDietTypes(DietType.valueOf(dietTypes.toUpperCase()));
    }

    @GetMapping("/get-food-by-user/{userId}")
    public List<FoodDTO> listFoodsByUser(@PathVariable String userId) {
        User user = userService.getUserById(Integer.parseInt(userId));
        return foodService.getAllFoodByUser(user);
    }

    @GetMapping("/search")
    public List<FoodDTO> foodsByName(@RequestParam String name) {
        return foodService.getFoodByName(name);
    }


    @PutMapping("/update/{id}")
    public void updateFoodNameById(@RequestParam("name") String name, @PathVariable("id") int foodId){
        foodService.updateFood(name,foodId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFoodById(@PathVariable("id") int foodId) {
        foodService.deleteFood(foodId);
    }

    @GetMapping(path="/groups")
    public List<GroupDTO> listFoods(HttpSession session) {


        //User user = (User) session.getAttribute("user");

        User newuser = userService.getUserById(1);
        Set<Group> groupsOfUser = newuser.getGroups();
        List<GroupDTO> representedGroups = new ArrayList<>();

        for (Group group : groupsOfUser) {
            representedGroups.add(groupDTO.representGroup(group.getId()));
        }

        return representedGroups;
    }
}
