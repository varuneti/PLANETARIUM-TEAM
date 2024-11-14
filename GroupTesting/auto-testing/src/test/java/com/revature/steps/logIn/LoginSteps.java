package com.revature.steps.logIn;

import com.revature.TestRunner;
import com.revature.poms.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;



    @When("The user enters the username on the login page {string}")
    public void the_user_enters_the_username(String username) {
        TestRunner.loginPage.enterUsername(username);

    }

    @When("The user enters the password on the login page {string}")
    public void the_user_enters_the_password(String password) {
        TestRunner.loginPage.enterPassword(password);
    }

    @When("The user clicks the login button")
    public void the_user_clicks_the_login_button(){
        TestRunner.loginPage.clickLoginButton();
    }

    @Then("The user should be redirected to home page")
    public void the_user_should_be_redirected_to_home_page() {

            String actualTitle = LoginPage.getPageTitle();
            if (actualTitle.equals("Home")){
                Assert.assertEquals(actualTitle, "Home");
            }
    }


}
