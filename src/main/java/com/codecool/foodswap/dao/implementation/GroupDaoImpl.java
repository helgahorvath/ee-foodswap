package com.codecool.foodswap.dao.implementation;

import com.codecool.foodswap.dao.GroupDao;
import com.codecool.foodswap.model.Group;

public class GroupDaoImpl extends EntityManagerJPA implements GroupDao{
    private static GroupDaoImpl ourInstance = new GroupDaoImpl();

    public static GroupDaoImpl getInstance() {
        return ourInstance;
    }

    private GroupDaoImpl() {
        super();
    }

    @Override
    public void add(Group group) {
        
    }

    @Override
    public void remove(Group group) {

    }
}
