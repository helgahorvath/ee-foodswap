package com.codecool.foodswap.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class EntityManagerJPA {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("foodswap");
    protected EntityManager em;
    protected EntityTransaction transaction;

    public EntityManagerJPA(){
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }
}
