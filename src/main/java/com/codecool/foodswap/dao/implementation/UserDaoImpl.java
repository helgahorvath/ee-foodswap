package com.codecool.foodswap.dao.implementation;

import com.codecool.foodswap.dao.UserDao;
import com.codecool.foodswap.model.User;

public class UserDaoImpl extends EntityManagerJPA implements UserDao {

    private static UserDaoImpl ourInstance = new UserDaoImpl();

    public static UserDaoImpl getInstance() {
        return ourInstance;
    }

    private UserDaoImpl() {
        super();
    }

    @Override
    public void add(User user) {
        transaction.begin();
        em.persist(user);
        transaction.commit();
        em.clear();
    }

    @Override
    public void remove(User user) {
        transaction.begin();
        em.remove(user);
        transaction.commit();
        em.clear();
    }
}
