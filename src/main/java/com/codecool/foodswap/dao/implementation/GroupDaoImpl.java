package com.codecool.foodswap.dao.implementation;

import com.codecool.foodswap.dao.GroupDao;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;

import java.util.ArrayList;
import java.util.List;

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
    public List<Group> findByName(String name) {
        return em.createQuery(
                "SELECT g FROM groups g WHERE g.name LIKE :name", Group.class)
                .setParameter("name", name).getResultList();
    }

    @Override
    public void addUserToGroup(User user, Group group) {
        List<User> toAdd = group.getUserList();
        toAdd.add(user);
        group.setUserList(toAdd);
        transaction.begin();
        em.persist(group);
        transaction.commit();
    }

    @Override
    public Group findById(int Id) {
        return (Group) em.createQuery(
                "SELECT g FROM groups g WHERE g.id = :id", Group.class)
                .setParameter("id", Id).getSingleResult();
    }
}
