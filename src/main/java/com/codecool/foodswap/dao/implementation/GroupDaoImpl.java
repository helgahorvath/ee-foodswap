package com.codecool.foodswap.dao.implementation;

import com.codecool.foodswap.dao.GroupDao;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;

import java.util.List;
import java.util.Set;

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
        em.close();
        em.clear();
    }

    @Override
    public void remove(Group group) {
        transaction.begin();
        em.remove(group);
        transaction.commit();
        em.close();
        em.clear();
    }

    @Override
    public Group findByName(String name) {
        return em.createQuery(
                "SELECT g FROM groups g WHERE g.name = :name", Group.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public void addUserToGroup(User user, Group group) {
        Set<User> toAdd = group.getUsers();
        toAdd.add(user);
        group.setUsers(toAdd);
        transaction.begin();
        em.persist(group);
        transaction.commit();
        em.close();
        em.clear();

    }
}
