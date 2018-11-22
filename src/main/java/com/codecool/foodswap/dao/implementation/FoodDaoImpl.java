package com.codecool.foodswap.dao.implementation;

import com.codecool.foodswap.dao.FoodDao;
import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;

import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl extends EntityManagerJPA implements FoodDao {


    @Override
    public void add(Food food) {
        transaction.begin();
        em.persist(food);
        transaction.commit();
        em.clear();
    }

    @Override
    public void remove(Food food) {
        transaction.begin();
        em.remove(food);
        transaction.commit();
        em.clear();
    }

    @Override
    public List<Food> getAllFoodByGroup(Group grp) {
        List<Food> groupsFoods = em.createQuery(
                "SELECT f FROM Food f " +
                    "WHERE f.container_group = ?", Food.class)
                .setParameter(0, grp)
                .getResultList();
        return groupsFoods;
    }
}
