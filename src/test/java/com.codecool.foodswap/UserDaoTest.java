package com.codecool.foodswap;

import com.codecool.foodswap.dao.implementation.EntityManagerJPA;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class UserDaoTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testUserDaoAddUser() throws IOException {
        UserDaoImpl userDaoImpl = mock(UserDaoImpl.class);
    }

    @AfterEach
    void tearDown() {
    }
}
