package com.codecool.foodswap.dao.implementation;

import com.codecool.foodswap.dao.GroupDao;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class GroupDaoImpl extends EntityManagerJPA implements GroupDao {
    private static GroupDaoImpl ourInstance = new GroupDaoImpl();

    public static GroupDaoImpl getInstance() {
        return ourInstance;
    }

    private GroupDaoImpl() {
        super();
    }

    @Override
    public void truncateTable(String tableName) {
        String stringQuery = "TRUNCATE TABLE " + tableName + " CASCADE;";
        Query query = em.createNativeQuery(stringQuery);
        query.executeUpdate();
    }

    @Override
    public void add(Group group) {
        transaction.begin();
        if (group == null)
            em.persist(group);
        else
            em.merge(group);
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
        transaction.begin();

        Set<User> toAdd = group.getUsers();
        toAdd.add(user);
        group.setUsers(toAdd);

        em.merge(group);
        transaction.commit();
        em.clear();

    }

    @Override
    public Group findById(int Id) {
        return (Group) em.createQuery(
                "SELECT g FROM groups g WHERE g.id = :id", Group.class)
                .setParameter("id", Id).getSingleResult();
    }
}
