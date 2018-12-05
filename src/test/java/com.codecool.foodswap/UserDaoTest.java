package com.codecool.foodswap;

import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import com.codecool.foodswap.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.persistence.NoResultException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class UserDaoTest {

    private UserDaoImpl userDaoImpl;
    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        userDaoImpl = UserDaoImpl.getInstance();
    }

    @Test
    void testUserDaoAddUser() throws IOException {
        user1 = new User("Test1", "Test1", "testemailemil1@gmail.com","123onetwothree");
        userDaoImpl.add(user1);
        User userFromTestDB1 = userDaoImpl.getUserById(1);
        assertEquals(user1.getId(), userFromTestDB1.getId());
    }


    @Test
    void testUserDaoRemoveUser() throws NoResultException {
        User userFromTestDB1 = userDaoImpl.getUserById(1);
        userDaoImpl.remove(userFromTestDB1);
        assertThrows(NoResultException.class, () -> { userDaoImpl.getUserById(1);});
    }

    @Test
    void testUserDaoVerifyUser() {

    }


    @AfterEach
    void tearDown() {

    }
}
