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

    public void removeUserFromGroup(User user){
        for (User u: userList) {
            if(u.getId() == user.getId()){
                userList.remove(u);
            }
        }
    }

   @Override
   public String toString() {
       return "Group{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", userList=" + userList +
               '}';
   }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> toAdd) {
        this.userList = toAdd;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
