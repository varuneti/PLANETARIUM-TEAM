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
    private UserDao userDao;
    private UserService userService;

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
        userDao = Mockito.mock(UserDao.class);
        userService = new UserServiceImp(userDao);
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

    @Test
    public void createEmptyUserNegativeTest() {
        user = new User();
        Optional<User> option = userDao.createUser(user);
        Assert.assertTrue(option.isEmpty());
    }

    @Test
    public void createUser0LengthNegativeTest() {
        user.setUsername("");
        Assert.assertThrows(UserFail.class, () -> {
            userDao.createUser(user);
        });
    }

    /*
            Just needs whatever official 31 length username we use for tests
    @Test
    public void createUser31LengthNegativeTest() {
        user.setUsername("INSERT USERNAME HERE");
        Assert.assertThrows(UserFail.class, () -> {
            userDao.createUser(user);
        });
    }
    */

    @Test
    public void createUserPass0LengthNegativeTest() {
        user.setPassword("");
        Assert.assertThrows(UserFail.class, () -> {
            userDao.createUser(user);
        });
    }

    /*
            Just needs whatever official 31 length password we use for tests
    @Test
    public void createUserPass31LengthNegativeTest() {
        user.setPassword("INSERT PASSWORD HERE");
        Assert.assertThrows(UserFail.class, () -> {
            userDao.createUser(user);
        });
    }
    */

    /*
            Just needs an existing username plugged in
    @Test
    public void createUserDupeNegativeTest() {
        testUser.setUsername(INSERT EXISTING USERNAME);
        Assert.assertThrows(UserFail.class, () -> {
            userDao.createUser(testUser);
        });
    }
    */

}