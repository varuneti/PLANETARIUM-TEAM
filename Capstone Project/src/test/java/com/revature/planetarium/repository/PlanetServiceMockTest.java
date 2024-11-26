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
/*
    @Test
    public void createPlanetPositiveTest() {
        setPlanetName("Pluto");
        try {
            Optional<Planet> actual = planetDaoImp.createPlanet(planet);
            Assert.assertEquals(actual.get(), planet);
        } catch(Exception e) {
            Assert.fail("Failed to create planet");
        }
    }
*/
    @Test
    public void createPlanet0LengthNegativeTest() {
        planet.setPlanetName("");
Assert.assertThrows(PlanetFail.class, () -> {
            service.createPlanet(planet);
        });
    }
/*
    @Test
    public void createPlanet31LengthNegativeTest() {
        setPlanetName("INSERT LONG PLANET NAME HERE IDK");
        try {
            Optional<Planet> actual = planetTest.createPlanet(planet);
            Assert.assertEquals(actual.get(), Optional.empty());
        } catch (Exception e) {
            Assert.fail("Is throwing a SQLiteException; should also be returning an empty Optional. Source code should be catching it");
        }
    }

 */
    @Test
    public void createPlanetDupeNegativeTest() {
        planet.setPlanetName("Pluto");
        Mockito.when(planetDaoImp.readPlanet(planet.getPlanetName())).thenReturn(Optional.empty());
        Mockito.when(planetDaoImp.createPlanet(planet)).thenReturn(Optional.of(planet));

        Planet actual = service.createPlanet(planet);

        Assert.assertEquals(actual, planet);
    }

    /*
            Idk about this one
    @Test
    public void deletePlanet() {
        setPlanetName("Evil Pluto");
        planetID = 1;
        Optional<Planet> created = planetTest.createPlanet(planet);
        int planetID = created.get().getPlanetId();
        Assert.assertTrue(planetTest.deletePlanet(planetID));
    }
    */

}
