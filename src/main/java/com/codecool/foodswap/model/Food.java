package com.codecool.foodswap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;
    @Column(name = "name")
    private String name;
    @Column(name = "picture")
    private String foodIMG;
    @Enumerated
    private DietType dietTypes;
    private LocalDate date;
    @Column(name = "expiration_date")
    private LocalDate expDate;
    @Column(name = "description")
    private String Description;

    @OneToOne
    @JsonIgnore
    private User owner;

    @ManyToOne
    @JsonIgnore
    private Group group;

    public Food(){}

    public Food(String name, String foodIMG, DietType dietTypes, String description, User owner, Group group) {
        this.name = name;
        this.foodIMG = foodIMG;
        this.date = getLocalDate();
        this.expDate = date.plusDays(2);
        this.Description = description;
        this.dietTypes = dietTypes;
        this.owner = owner;
        this.group = group;
    }

    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
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

    public DietType getDietTypes() {
        return dietTypes;
    }

    public void setDietTypes(DietType dietTypes) {
        this.dietTypes = dietTypes;
    }


    public void setOwner(User owner) {
        this.owner = owner;
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

    public Group getGroup() {
        return group;
    }



    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", name='" + name + '\'' +
                ", foodIMG='" + foodIMG + '\'' +
                ", dietTypes=" + dietTypes +
                ", date=" + date +
                ", expDate=" + expDate +
                ", Description='" + Description + '\'' +
                ", owner=" + owner +
                '}';
    }
}
