package com.revature.planetarium.repository;

import com.revature.planetarium.entities.Planet;
import com.revature.planetarium.exceptions.PlanetFail;
import com.revature.planetarium.repository.planet.PlanetDaoImp;
//import com.revature.planetarium.utility.Setup;
import com.revature.planetarium.service.planet.PlanetService;
import com.revature.planetarium.service.planet.PlanetServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

public class PlanetServiceMockTest {

    private Planet planet;
    private PlanetDaoImp planetDaoImp;
    private PlanetService service;

    private static String validGetPlanetName;
    private static Planet validGetPlanetData;
    private static String invalidGetPlanetName;

    public static int planetID;

    public void setPlanetName(String planetName) {
        planet.setPlanetName(planetName);
    }

    @BeforeClass
    public static void setup(){
        //Setup.main(new String[]{});
        validGetPlanetName = "Earth";
        validGetPlanetData = new Planet(1, "Earth", 1);
        invalidGetPlanetName = "Saturn";
    }

    @Before
    public void pretest(){
        planetDaoImp = Mockito.mock(PlanetDaoImp.class);

        service = new PlanetServiceImp(planetDaoImp);

        planet = new Planet();
    }

    @Test
    public void createPlanetPositiveTest() {
        planet.setPlanetName("Pluto");
        Mockito.when(planetDaoImp.readPlanet(planet.getPlanetName())).thenReturn(Optional.empty());
        Mockito.when(planetDaoImp.createPlanet(planet)).thenReturn(Optional.of(planet));
        Planet actual = service.createPlanet(planet);
        Assert.assertEquals(actual, planet);
    }

    @Test
    public void createPlanet0LengthNegativeTest() {
        planet.setPlanetName("");
        Assert.assertThrows(PlanetFail.class, () -> {
            service.createPlanet(planet);
        });
    }

    @Test
    public void createPlanet30PlusLengthTest() {
        planet.setPlanetName("Insert Super Long Name Planet Here");
        Assert.assertThrows(PlanetFail.class, () -> {
            service.createPlanet(planet);
        });
    }

    @Test
    public void createPlanetDupeNegativeTest() {
        planet.setPlanetName("Pluto");
        Mockito.when(planetDaoImp.readPlanet(planet.getPlanetName())).thenReturn(Optional.empty());
        Mockito.when(planetDaoImp.createPlanet(planet)).thenReturn(Optional.of(planet));
        Planet actual = service.createPlanet(planet);
        Assert.assertEquals(actual, planet);
    }

    @Test
    public void deletePlanetPositiveTest() {
        String planetName = "Mars";
        String expectedResult = "Planet deleted successfully";
        Mockito.when(planetDaoImp.deletePlanet(planetName)).thenReturn(true);
        Assert.assertEquals(service.deletePlanet(planetName), expectedResult);
    }

    @Test
    public void deletePlanetNegativeTest() {
        String planetName = "Evil Pluto";
        Mockito.when(planetDaoImp.deletePlanet(planetName)).thenReturn(false);
        Assert.assertThrows(PlanetFail.class, () -> service.deletePlanet(planetName));
    }
}
