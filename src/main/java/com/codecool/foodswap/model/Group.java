package com.codecool.foodswap.model;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "groupList")
    private List<User> userList;

    public Group(String name) {
        this.name = name;
    }

    public Group(){}

    public void addUserToGroup(com.codecool.foodswap.model.User user) {
        this.userList.add(user);
    }

    public void removeUserFromGroup(com.codecool.foodswap.model.User user){
        for (com.codecool.foodswap.model.User u: userList) {
            if(u.getId() == user.getId()){
                userList.remove(u);
            }
        }
    }
}
