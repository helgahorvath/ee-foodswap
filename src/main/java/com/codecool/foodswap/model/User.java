package com.codecool.foodswap.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany
    private List<DietType> dietTypes = new ArrayList<>();
    private String userImg;
    private int upVotes;
    private Rank rank = Rank.KITCHEN_HELPER;
    private List<Food> foodsOffered = new ArrayList<>();
    @ManyToMany(mappedBy = "userList")
    private List<Group> groupList = new ArrayList<>();


    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(){

    }

    public void addDietType(DietType dietType) {

    }

    public void changeRank(Rank rank) {
        this.rank = rank;
    }


    public void joinGroup(Group group) {
        this.groupList.add(group);
    }

    public int getId() {
        return id;
    }
}
