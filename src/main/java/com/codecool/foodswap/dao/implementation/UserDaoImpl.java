package com.codecool.foodswap.dao.implementation;

import com.codecool.foodswap.dao.UserDao;
import com.codecool.foodswap.model.User;

public class UserDaoImpl extends EntityManagerJPA implements UserDao {
    
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
