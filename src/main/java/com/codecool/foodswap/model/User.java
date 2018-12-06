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
    @ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
    private Set<Group> groups = new HashSet<>();


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

    public void addDietTypes(List<DietType> dietTypes) {
        this.dietTypes.addAll(dietTypes);
    }

    public void addToGroup(Group group) {
        this.groups.add(group);
    }

    public void changeRank(Rank rank) {
        this.rank = rank;
    }

    public void joinGroup(Group group) {
        this.groups.add(group);
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
