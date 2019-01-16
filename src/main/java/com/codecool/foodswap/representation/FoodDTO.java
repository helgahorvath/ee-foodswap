package com.codecool.foodswap.representation;

import com.codecool.foodswap.model.DietType;

import java.time.LocalDate;
import java.util.List;

public class FoodDTO {

    private String name;
    private String description;
    private String foodIMG;
    private DietType dietTypes;
    private LocalDate expDate;
    private Integer ownerId;

    public FoodDTO(String name, String description, String foodIMG, DietType dietTypes, LocalDate expDate, Integer ownerId) {
        this.name = name;
        this.description = description;
        this.foodIMG = foodIMG;
        this.dietTypes = dietTypes;
        this.expDate = expDate;
        this.ownerId = ownerId;
    }

    public FoodDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoodIMG() {
        return foodIMG;
    }

    public void setFoodIMG(String foodIMG) {
        this.foodIMG = foodIMG;
    }

    public DietType getDietTypes() {
        return dietTypes;
    }

    public void setDietTypes(DietType dietTypes) {
        this.dietTypes = dietTypes;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "FoodDTO{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", foodIMG='" + foodIMG + '\'' +
                ", dietTypes=" + dietTypes +
                ", expDate=" + expDate +
                ", ownerId=" + ownerId +
                '}';
    }
}
