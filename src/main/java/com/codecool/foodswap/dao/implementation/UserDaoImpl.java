package com.codecool.foodswap.dao.implementation;

import com.codecool.foodswap.dao.UserDao;
import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;

import java.sql.SQLOutput;
import java.util.List;

public class UserDaoImpl extends EntityManagerJPA implements UserDao {

    private static UserDaoImpl ourInstance;

    public static UserDaoImpl getInstance() {
        if(ourInstance == null){
            return ourInstance = new UserDaoImpl();
        }
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



    @Override
    public int verifyUser(String email, String password) {
        List<User> users = em.createQuery(
                "SELECT u FROM users u WHERE u.email LIKE :email AND u.password = :password")
                .setParameter("email", email).setParameter("password", password).getResultList();
        for (User u: users) {
            return u.getId();
        }
    return 0;
    }

    @Override
    public void joinGroup(User user, Group group) {
        user.addToGroup(group);
        transaction.begin();
        em.persist(user);
        transaction.commit();
        em.clear();
    }

    @Override
    public void addDietTypes(User user, List<DietType> dietTypes) {
        user.addDietTypes(dietTypes);
        transaction.begin();
        em.merge(user);
        transaction.commit();
        em.clear();
    }

    @Override
    public User getUserById(int Id) {
        User user = em.createQuery(
                "SELECT u FROM users u WHERE u.id = :id", User.class)
                .setParameter("id", Id).getSingleResult();
        return user;
    }

    @Override
    public boolean checkIfEmailExisting(String email) {
        try {
            User user = em.createQuery(
                    "SELECT u FROM users u WHERE u.email LIKE :email", User.class)
                    .setParameter("email", email).getSingleResult();
        } catch(javax.persistence.NoResultException e) {
            return true;
        }

        return false;
    }
}
