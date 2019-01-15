package com.codecool.foodswap.representation;

import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FoodDTO {

    @Autowired
    private FoodService foodService;


    private String name;
    private String description;
    private String foodIMG;
    private List<DietType> dietTypes;
    private LocalDate expDate;
    private Integer ownerId;

    public FoodDTO(String name, String description, String foodIMG, List<DietType> dietTypes, LocalDate expDate, Integer ownerId) {
        this.name = name;
        this.description = description;
        this.foodIMG = foodIMG;
        this.dietTypes = dietTypes;
        this.expDate = expDate;
        this.ownerId = ownerId;
    }

    public List<FoodDTO> foodsByGroup (Group group) {
        List<FoodDTO> FoodDTO = new ArrayList<>();

        for(Food food : foodService.getAllFoodByGroup(group)) {
            this.name = food.getName();
            this.description = food.getDescription();
            this.foodIMG = food.getFoodIMG();
            this.expDate = food.getExpDate();
            this.dietTypes = food.getDietTypes();
            this.ownerId = food.getOwner().getId();
            FoodDTO foodDTO = new FoodDTO(name,description,foodIMG,dietTypes,expDate,ownerId);
            FoodDTO.add(foodDTO);
        }
        return FoodDTO;
    }
}
