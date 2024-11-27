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
import org.junit.After;

import java.util.Optional;

import static com.revature.planetarium.utility.JavalinSetup.userDao;
//import com.revature.utility.Setup;

public class UserServiceMockTest {

    private static String validUsername;
    private static String validPassword;
    private static String invalidUsername;
    private static String invalidPassword;
    private User user;
    private UserDao userDaoImp;
    private UserService service;

    @BeforeClass
    public static void setup(){
        validUsername = "robin";
        validPassword = "sideKick101";
        invalidUsername = "Batman";
        invalidPassword = "I am the night";
        //Setup.main(new String[]{});
    }


    @Before
    public void pretest() {
        userDaoImp = Mockito.mock(UserDao.class);
        service = new UserServiceImp(userDaoImp);
        user = new User();
        user.setUsername(validUsername);
        user.setPassword(validPassword);
    }

    /*
    @After

    public void posttest() {
        Setup.main(new String[]{});
    } */

    @Test
    public void createUserPositiveTest() {
        Mockito.when(userDaoImp.createUser(user)).thenReturn(Optional.of(user));
        String Actualresult = service.createUser(user);
        String expectedResult = "Created user with username " + validUsername + " and password " + validPassword;;
        Assert.assertEquals(expectedResult, Actualresult);
    }

    @Test
    public void createUser0LengthNegativeTest() {
        user.setUsername("");
        UserFail failed = Assert.assertThrows(UserFail.class, () -> {
            service.createUser(user);
        });
        Assert.assertEquals("Username must be between 1 and 30 characters", failed.getMessage());
    }

    @Test
    public void createUser31LengthNegativeTest() {
        user.setUsername("This username is way to long to use for this");
        UserFail failed = Assert.assertThrows(UserFail.class, () -> {
            service.createUser(user);
        });
        Assert.assertEquals("Username must be between 1 and 30 characters", failed.getMessage());
    }

    @Test
    public void createUserPass0LengthNegativeTest() {
        user.setPassword("");
        UserFail failed = Assert.assertThrows(UserFail.class, () -> {
            service.createUser(user);
        });
        Assert.assertEquals("Password must be between 1 and 30 characters", failed.getMessage());
    }

    @Test
    public void createUserPass31LengthNegativeTest() {
        user.setPassword("This password is way to long to use for this");
        UserFail failed = Assert.assertThrows(UserFail.class, () -> {
            service.createUser(user);
        });
        Assert.assertEquals("Password must be between 1 and 30 characters", failed.getMessage());
    }

    @Test
    public void createUserDupeNegativeTest() {
        user.setUsername("Batman");
        Mockito.when(userDaoImp.findUserByUsername(user.getUsername())).thenReturn(Optional.of(user));
        UserFail failed = Assert.assertThrows(UserFail.class, () -> {
            service.createUser(user);
        });
        Assert.assertEquals("Username is already in use", failed.getMessage());
    }

    @Test
    public void loginUserPositiveTest() {
        Mockito.when(userDaoImp.findUserByUsername(user.getUsername())).thenReturn(Optional.of(user));
        User actualUser = service.authenticate(user);
        Assert.assertEquals(user, actualUser);
    }

    @Test
    public void loginBadUserNegativeTest() {
        Mockito.when(userDaoImp.findUserByUsername(user.getUsername())).thenReturn(Optional.empty());
        UserFail failed = Assert.assertThrows(UserFail.class, () -> {
            service.authenticate(user);
        });
        Assert.assertEquals("Username and/or password do not match", failed.getMessage()); 
    }

    @Test
    public void loginBadPassNegativeTest() {
        User testUser = new User();
        testUser.setPassword("My Birthday");
        Mockito.when(userDaoImp.findUserByUsername(user.getUsername())).thenReturn(Optional.of(testUser));
        UserFail failed = Assert.assertThrows(UserFail.class, () -> {
            service.authenticate(user);
        });
        Assert.assertEquals("Username and/or password do not match", failed.getMessage());
    }
}