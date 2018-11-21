package com.codecool.foodswap.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<DietType> dietTypes = new ArrayList<>();
    private String userImg;
    private int upVotes;
    private Rank rank = Rank.KITCHEN_HELPER;
    private List<Food> foodsOffered = new ArrayList<>();
    private static AtomicInteger nextId = new AtomicInteger();
    private List<Group> groupList = new ArrayList<>();


    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = nextId.incrementAndGet();
    }

    public void addDietType(DietType dietType) {

    }

    public void changeRank(Rank rank) {
        this.rank = rank;
    }

    public void offerFood(String name, String foodImg, DietType dietType, String description) {
        this.foodsOffered.add(new Food());
    }

    public void joinGroup(Group group) {
        this.groupList.add(group);
    }
}
