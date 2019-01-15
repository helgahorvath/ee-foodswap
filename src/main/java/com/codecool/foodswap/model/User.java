package com.codecool.foodswap.model;

import org.hibernate.annotations.Cascade;

import com.codecool.foodswap.util.Bcrypt;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    @NotBlank(message = "Enter a valid e-mail address.")
    private String email;

    @Size(min = 5, message = "Password must be at least 5 characters long.")
    private String password;

    @Enumerated
    @ElementCollection(targetClass = DietType.class)
    private List<DietType> dietTypes = new ArrayList<>();

    private String userImg;
    private int upVotes;
    private Rank rank = Rank.KITCHEN_HELPER;
    @ManyToMany(mappedBy = "users", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Group> groups = new HashSet<>();


    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<DietType> getDietTypes() {
        return dietTypes;
    }

    public void setDietTypes(List<DietType> dietTypes) {
        this.dietTypes = dietTypes;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public void addDietType(DietType dietType) {
        this.dietTypes.add(dietType);

    }

    public void addDietTypes(List<DietType> dietTypes) {
        this.dietTypes.addAll(dietTypes);
    }


    public void changeRank(Rank rank) {
        this.rank = rank;
    }

    public void joinGroup(Group group) {
        this.groups.add(group);
    }

    public void joinGroup(Group group, boolean add) {
        this.groups.add(group);
        if (group != null && add) {
            group.addUser(this, false);
        }
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

    public Set<Group> getGroups() {
        return groups;
    }
}
