package com.codecool.foodswap.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class EntityManagerJPA {
    private EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction transaction;

//    EntityManagerJPA(){
//        emf = Persistence.createEntityManagerFactory("foodswap");
//        em = emf.createEntityManager();
//        transaction = em.getTransaction();
//    }

    EntityManagerJPA(){
        emf = Persistence.createEntityManagerFactory("food_swap_test");
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(String testDB) {
        emf = Persistence.createEntityManagerFactory(testDB);
    }
}
