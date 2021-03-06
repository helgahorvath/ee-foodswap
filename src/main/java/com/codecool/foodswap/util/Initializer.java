package com.codecool.foodswap.util;

import com.codecool.foodswap.service.FoodService;
import com.codecool.foodswap.service.GroupService;
import com.codecool.foodswap.service.UserService;
import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Initializer {

    @Autowired
    private FoodService foodService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {

        User newuser = new User("Józsi", "Kovács", "mail", Bcrypt.hashPassword("jelszo"));
        User masikuser = new User("Béla", "Szabó", "email", Bcrypt.hashPassword("masikjelszo"));
        userService.add(newuser);
        userService.add(masikuser);

        Group newgroup = new Group("finomkajak", newuser);
        Group masikgroup = new Group("nemfinomkajak", masikuser);

        groupService.add(newgroup);
        groupService.add(masikgroup);

        userService.joinGroup(newuser, newgroup);
        userService.joinGroup(masikuser, masikgroup);


        Food newfood = new Food("etel", "kep", DietType.GLUTENFREE , "ez a leiras", newuser, newgroup);
        Food masikfood = new Food("kaja", "nemkep",DietType.LACTOSEFREE, "leiras", masikuser, masikgroup);

        foodService.add(newfood);
        foodService.add(masikfood);
    }

}
