package com.codecool.foodswap.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Group {

    private int groupId;
    private String name;
    private List<User> userList;
    private static AtomicInteger nextId = new AtomicInteger();

    public Group(String name) {
        this.groupId = nextId.incrementAndGet();
        this.name = name;
    }

    public void addUserToGroup(User user) {
        this.userList.add(user);
    }
}
