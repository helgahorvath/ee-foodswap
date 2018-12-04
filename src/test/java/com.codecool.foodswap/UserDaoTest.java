package com.codecool.foodswap;

import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import com.codecool.foodswap.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertThat;
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
        user2 = new User("Test2", "Test2", "testemailemil2@gmail.com","123onetwothree");

        userDaoImpl.add(user1);
        userDaoImpl.add(user2);

        User userFromTestDB1 = userDaoImpl.getUserById(1);
        User userFromTestDB2 = userDaoImpl.getUserById(2);
        assertEquals(user1.getId(), userFromTestDB1.getId());
        assertEquals(user2.getId(), userFromTestDB2.getId());
    }

    @Test
    void testUserDaoRemoveUser() throws IOException {
        List<User> usersInDB = userDaoImpl.getAllUser();

        User userFromTestDB1 = userDaoImpl.getUserById(1);
        User userFromTestDB2 = userDaoImpl.getUserById(2);

        userDaoImpl.remove(userFromTestDB2);
        usersInDB = userDaoImpl.getAllUser();

        assertEquals(usersInDB.size(), 1);
    }

    @AfterEach
    void tearDown() {

    }
}
