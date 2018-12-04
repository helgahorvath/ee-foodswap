package com.codecool.foodswap.model;

import com.codecool.foodswap.util.Bcrypt;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated
    @ElementCollection(targetClass = DietType.class)
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
        this.email = email;
        this.password = Bcrypt.hashPassword(password);
    }

    public User(){

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

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
