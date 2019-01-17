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

import com.codecool.foodswap.representation.GroupDTO;
import com.codecool.foodswap.service.FoodService;
import com.codecool.foodswap.service.UserService;
import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import com.codecool.foodswap.repositories.FoodRepository;
import com.codecool.foodswap.repositories.GroupRepository;
import com.codecool.foodswap.repositories.UserRepository;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Component
@Scope("session")
@RestController
public class ListFoodsREST {


    private GroupRepository groupRepository;


    private FoodRepository foodRepository;

    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupDTO groupDTO;

    @Autowired
    private FoodService foodService;

    public ListFoodsREST(GroupRepository groupRepository, FoodRepository foodRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.foodRepository = foodRepository;
        this.userRepository = userRepository;
    }

    public ListFoodsREST() {
    }

    public ListFoodsREST(FoodService foodService) {
        this.foodService = foodService;
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

        for (Group group: groupsOfUser) {
            representedGroups.add(groupDTO.representGroup(group.getId()));
        }

        return representedGroups;
    }
}
