package com.codecool.foodswap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity(name= "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "groupList")
    private List<User> userList= new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public Group(){}

    public void addUserToGroup(User user) {
        this.userList.add(user);
    }

    public void removeUserFromGroup(User user){
        for (User u: userList) {
            if(u.getId() == user.getId()){
                userList.remove(u);
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
