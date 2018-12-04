package com.codecool.foodswap;

import com.codecool.foodswap.dao.implementation.EntityManagerJPA;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import com.codecool.foodswap.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class UserDaoTest {

     private UserDaoImpl userDaoImpl;
    private User user;

    @BeforeEach
    void setUp() {
        userDaoImpl = UserDaoImpl.getInstance();
        user = new User("Robert", "Katona", "emailemil@gmail.com","123onetwothree");
    }

    @Test
    void testUserDaoAddUser() throws IOException {
        boolean result = true;
        userDaoImpl.add(user);
//        User userFromTestDB = userDaoImpl.getUserById(1);
//        assertEquals(user.getId(), userFromTestDB.getId());
    }

    @AfterEach
    void tearDown() {
    }
}
