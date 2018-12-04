package com.codecool.foodswap.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name= "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "groups_users",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> users = new HashSet<>();

    public Group(String name, User creator) {
        this.name = name;
        this.users.add(creator);
    }

    public Group(){}


    public void removeUserFromGroup(User user){
        for (User u: users) {
            if(u.getId() == user.getId()){
                users.remove(u);
            }
        }
    }

   @Override
   public String toString() {
       return "Group{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", userList=" + users +
               '}';
   }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> toAdd) {
        this.users = toAdd;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
