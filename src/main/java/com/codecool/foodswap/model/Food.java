package com.codecool.foodswap.model;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Food {

    private long foodId;
    private String name;
    private String foodIMG;
    private List<DietType> dietTypes;
    private LocalDate date;
    private LocalDate expDate;
    private String Description;
    private User owner;

    public Food(long foodId, String name, String foodIMG, List<DietType> dietTypes, String description) {
        this.foodId = foodId;
        this.name = name;
        this.foodIMG = foodIMG;
        this.dietTypes = dietTypes;
        this.date = getLocalDate();
        this.expDate = date.plusDays(2);
        this.Description = description;
    }

    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodIMG() {
        return foodIMG;
    }

    public void setFoodIMG(String foodIMG) {
        this.foodIMG = foodIMG;
    }

    public List<DietType> getDietTypes() {
        return dietTypes;
    }

    public void setDietTypes(List<DietType> dietTypes) {
        this.dietTypes = dietTypes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
