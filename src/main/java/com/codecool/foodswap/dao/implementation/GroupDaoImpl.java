package com.codecool.foodswap.dao.implementation;

import com.codecool.foodswap.dao.GroupDao;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;

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
        transaction.begin();
        em.persist(group);
        transaction.commit();
        em.clear();
    }

    @Override
    public void remove(Group group) {
        transaction.begin();
        em.remove(group);
        transaction.commit();
        em.clear();
    }

    @Override
    public void addMemeber(User user) {

    }
}
