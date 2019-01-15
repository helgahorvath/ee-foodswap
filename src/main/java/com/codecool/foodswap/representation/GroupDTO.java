package com.codecool.foodswap.representation;

import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import com.codecool.foodswap.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GroupDTO {

    @Autowired
    private transient GroupService groupService;


    public int id;
    public String name;
    public Set<Integer> users;
    public Set<Integer> foods;


    public GroupDTO representGroup(int id) {
        Group group = groupService.findById(id);
        this.id = group.getId();
        this.name = group.getName();
        this.users = group.getUsers().stream().mapToInt(User::getId).boxed().collect(Collectors.toSet());
        this.foods = group.getFoods().stream().mapToInt(Food::getFoodId).boxed().collect(Collectors.toSet());
        return this;
    }


}
