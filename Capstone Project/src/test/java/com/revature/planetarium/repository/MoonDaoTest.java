package com.revature.planetarium.repository;

import com.revature.planetarium.Utility;
import com.revature.planetarium.entities.Moon;
import com.revature.planetarium.entities.Planet;
import com.revature.planetarium.repository.moon.MoonDao;
import com.revature.planetarium.repository.moon.MoonDaoImp;
import com.revature.planetarium.repository.planet.PlanetDao;
import com.revature.planetarium.repository.planet.PlanetDaoImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

public class MoonDaoTest {

    private MoonDao moonDao;

    private static String validGetMoonName;
    private static Moon validGetMoonData;
    //private static String invalidGetMoonName;

    @BeforeClass
    public static void setupTestData(){
        validGetMoonName = "Luna";
        validGetMoonData = new Moon(1, "Luna", 1);
        //invalidGetMoonName = "Moon";

    }

    @Before
    public void setupTestObjects(){
        Utility.main(new String[]{});
        // initialize the implementation class
        moonDao = new MoonDaoImp();
    }

    @Test
    public void findMoonByNamePositiveTest(){
        /*
            Optionals are useful when you can't guarantee what data is going to be returned
            by a method. It gives you a consistent return object you can then perform validation
            on to determine what action to take, typically determined by whether your optional
            contains an object of the expected type which is indicated by a Generic declaration
         */
        Optional<Moon> result = moonDao.readMoon(validGetMoonName);
        /*
            Once you have your results back you need to validate the results are what you expect.
            There are multiple ways you can do this, choose a way that makes sense to you and
            your team, and ideally covers as many edge cases you can think of
         */
        Moon moon = result.get();
        Assert.assertEquals(validGetMoonData, moon);
    }
/*
    @Test
    public void findPlanetByNameNegativeTest(){
        /*
            Since we expect no user data in our negative test we only need to set up a
            non-existent username for our test, pass it to the get method, and validate
            the optional returned is empty

        Optional<Planet> result = planetDao.readPlanet(invalidGetPlanetName);
        Assert.assertTrue(result.isEmpty());
    }

 */
}
