package com.codecool.foodswap.model;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<DietType> foodDietTypes = new ArrayList(){};
        foodDietTypes.add(DietType.SUGARFREE);
        foodDietTypes.add(DietType.VEGAN);

        Food food = new Food(1,"food", "food.img", foodDietTypes, "yummy food");
        System.out.println(food.getFoodId());
        System.out.println(food.getName());
        System.out.println(food.getFoodIMG());
        System.out.println(food.getDietTypes());
        System.out.println(food.getDate());
        System.out.println(food.getExpDate());
        System.out.println(food.getDescription());
    }

}
