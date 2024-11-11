package com.revature;

import com.revature.poms.LoginPage;
import com.revature.poms.RegistrationPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.revature.steps", features = "classpath:Features", plugin = "pretty")
public class registrationRunner {

    public static WebDriver driver;

    public static LoginPage loginPage;

    public static RegistrationPage registrationPage;

    @BeforeClass
    public static void setup(){
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
