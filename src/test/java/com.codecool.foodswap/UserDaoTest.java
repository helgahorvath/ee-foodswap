package com.codecool.foodswap;

import com.codecool.foodswap.dao.implementation.GroupDaoImpl;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.persistence.NoResultException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class UserDaoTest {

    private UserDaoImpl userDaoImpl;
    private GroupDaoImpl groupDaoImpl;
    private User testUser1;
    private User testUser2;
    private User testCreator1;
    private Group testGroup1;


    @BeforeEach
    void setUp() {
        userDaoImpl = UserDaoImpl.getInstance();
        testUser1 = new User("Test1", "Test1", "testemailemil1@gmail.com","123onetwothree1");
        testUser2 = new User("Test2", "Test2", "testemailemil2@gmail.com","123onetwothree2");
        testCreator1 = new User("Creator1", "Creator1", "creatoremailemil3@gmail.com","123onetwothree3");
        userDaoImpl.add(testUser1);
        userDaoImpl.add(testUser2);
        userDaoImpl.add(testCreator1);
        testGroup1 = new Group("Testgroup1", testCreator1);

    }

    @Test
    void testUserDaoAddUser() throws IOException {
        User userFromTestDB1 = userDaoImpl.getUserById(1);
        assertEquals(testUser1.getId(), userFromTestDB1.getId());
    }


    @Test
    void testUserDaoRemoveUser() throws NoResultException {
        User userFromTestDB1 = userDaoImpl.getUserById(1);
        userDaoImpl.remove(userFromTestDB1);
        assertThrows(NoResultException.class, () -> { userDaoImpl.getUserById(1);});
    }

    @Test
    void testUserDaoVerifyUser() {
        String emailGood1 = "testemailemil1@gmail.com";
        String pswGood1 = "123onetwothree1";
        String emailGood2 = "testemailemil2@gmail.com";
        String pswGood2 = "123onetwothree2";

        String emailWrong = "bad@gmail.com";
        String pswWrong = "bad123";

        assertEquals(userDaoImpl.getUserById(1).getId(), userDaoImpl.verifyUser(emailGood1,pswGood1));
        assertEquals(userDaoImpl.getUserById(2).getId(), userDaoImpl.verifyUser(emailGood2,pswGood2));
        assertThrows(NoResultException.class, () -> { userDaoImpl.verifyUser(emailWrong, pswWrong);});
        assertThrows(NoResultException.class, () -> { userDaoImpl.verifyUser(emailWrong, pswGood1);});
    }

    @Test
    void testUserDaoJoinGroup() {
        testUser1.joinGroup(testGroup1);


    }
    @AfterEach
    void tearDown() {

    }
}
