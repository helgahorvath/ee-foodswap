package com.codecool.foodswap.dao.implementation;

import javax.persistence.*;

public abstract class EntityManagerJPA {
    private EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction transaction;

//    EntityManagerJPA(){
//        emf = Persistence.createEntityManagerFactory("foodswap");
//        em = emf.createEntityManager();
//        transaction = em.getTransaction();
//    }

    EntityManagerJPA() {
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

    public EntityTransaction getTransaction() {
        return transaction;
    }

    public abstract void truncateTable(String tableName);
}