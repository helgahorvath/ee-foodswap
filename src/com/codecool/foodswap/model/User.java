package com.codecool.foodswap.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class User {

    private int id;
    private String firstName;
    private String lastName;
    private List<DietType> dietTypes;
    private String userImg;
    private int upVotes;
    private Rank rank;
    private List<Food> foodsOffered;
    private static AtomicInteger nextId = new AtomicInteger();

    public User(String firstName, String lastName, List<DietType> dietTypes, String userImg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dietTypes = dietTypes;
        this.userImg = userImg;
        this.id = nextId.incrementAndGet();
    }

    public void addDietType(DietType dietType) {

    }


}
