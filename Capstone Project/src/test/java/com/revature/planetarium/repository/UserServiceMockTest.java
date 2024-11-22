package com.revature.planetarium.repository;

import com.revature.planetarium.entities.User;
import com.revature.planetarium.exceptions.UserFail;
import com.revature.planetarium.repository.user.UserDao;
import com.revature.planetarium.service.user.UserService;
import com.revature.planetarium.service.user.UserServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static com.revature.planetarium.utility.JavalinSetup.userDao;

public class UserServiceMockTest {

    private static String validUsername;
    private static String validPassword;
    private static String invalidUsername;
    private static String invalidPassword;
    private User user;
    private UserDao userDao;
    private UserService userService;

    @BeforeClass
    public static void setup(){
        validUsername = "robin";
        validPassword = "sideKick101";
        invalidUsername = "Batman";
        invalidPassword = "I am the night";
    }


    @Before
    public void pretest() {
        userDao = Mockito.mock(UserDao.class);
        userService = new UserServiceImp(userDao);
        user = new User();
        user.setUsername(validUsername);
        user.setPassword(validPassword);
    }

    @Test
    public void createUserPositiveTest() {
        Mockito.when(userDao.createUser(user)).thenReturn(Optional.of(user));
        String Actualresult = userService.createUser(user);
        String expectedResult = "Created user with username " + validUsername + " and password " + validPassword;;
        Assert.assertEquals(expectedResult, Actualresult);
    }

    @Test
    public void createUserNegativeTest() {
        user.setUsername(invalidUsername);
        user.setPassword(invalidPassword);
        Mockito.when(userDao.createUser(user)).thenReturn(Optional.of(user));
        String Actualresult = userService.createUser(user);
        String expectedResult = "Failed to create user, please try again";
        Assert.assertEquals(expectedResult, Actualresult);
    }

}
