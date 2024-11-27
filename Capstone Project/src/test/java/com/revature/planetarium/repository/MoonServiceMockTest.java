package com.revature.planetarium.repository;

import com.revature.planetarium.entities.Moon;
import com.revature.planetarium.exceptions.MoonFail;
import com.revature.planetarium.repository.moon.MoonDaoImp;
import com.revature.planetarium.service.moon.MoonService;
import com.revature.planetarium.service.moon.MoonServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

public class MoonServiceMockTest {

    private Moon moon;
    private MoonDaoImp moonDaoImp;
    private MoonService service;

    private static String validGetMoonName;
    private static Moon validGetMoonData;
    private static String invalidGetMoonName;

    public static int moonID;

    public void setMoonName(String moonName) {
        moon.setMoonName(moonName);
    }

    @BeforeClass
    public static void setup(){
        //Setup.main(new String[]{});
        validGetMoonName = "Luna";
        validGetMoonData = new Moon(1, "Luna", 1);
        invalidGetMoonName = "Krypton";
    }

    @Before
    public void pretest(){
        moonDaoImp = Mockito.mock(MoonDaoImp.class);

        service = new MoonServiceImp(moonDaoImp);

        moon = new Moon();
    }

    @Test
    public void createMoonPositiveTest() {
        moon.setMoonName("Europa");
        Mockito.when(moonDaoImp.readMoon(moon.getMoonName())).thenReturn(Optional.empty());
        Mockito.when(moonDaoImp.createMoon(moon)).thenReturn(Optional.of(moon));
        Moon actual = service.createMoon(moon);
        Assert.assertEquals(actual, moon);
    }

    @Test
    public void createMoon0LengthNegativeTest() {
        moon.setMoonName("");
        Assert.assertThrows(MoonFail.class, () -> {
            service.createMoon(moon);
        });
    }

    @Test
    public void createMoon30PlusLengthTest() {
        moon.setMoonName("Insert Super Long Name Moon Here");
        Assert.assertThrows(MoonFail.class, () -> {
            service.createMoon(moon);
        });
    }

    @Test
    public void createMoonDupeNegativeTest() {
        moon.setMoonName("Luna");
        Mockito.when(moonDaoImp.readMoon(moon.getMoonName())).thenReturn(Optional.empty());
        Mockito.when(moonDaoImp.createMoon(moon)).thenReturn(Optional.of(moon));
        Moon actual = service.createMoon(moon);
        Assert.assertEquals(actual, moon);
    }

    @Test
    public void deleteMoonPositiveTest() {
        String planetName = "Titan";
        String expectedResult = "Moon deleted successfully";
        Mockito.when(moonDaoImp.deleteMoon(planetName)).thenReturn(true);
        Assert.assertEquals(service.deleteMoon(planetName), expectedResult);
    }

    @Test
    public void deleteMoonNegativeTest() {
        String planetName = "Evil Luna";
        Mockito.when(moonDaoImp.deleteMoon(planetName)).thenReturn(false);
        Assert.assertThrows(MoonFail.class, () -> service.deleteMoon(planetName));
    }

}
