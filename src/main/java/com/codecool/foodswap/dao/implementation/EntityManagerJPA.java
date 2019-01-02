package com.codecool.foodswap.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class EntityManagerJPA {
    // do not put code outside functions if possible
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("foodswap");
    EntityManager em;
    EntityTransaction transaction;

    EntityManagerJPA(){
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }
}
