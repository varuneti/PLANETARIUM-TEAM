package com.revature.steps.shared;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SharedSteps {
    //starting point of all the test cases
    @Given("The user is on the login page at URL {string}")
    public void the_user_is_on_the_login_page_at_url(String url) {
        TestRunner.driver.get(url);
    }
    //shared by registration tests
    @When("The user clicks the registration button")
    public void the_user_clicks_the_registration_button() {
        TestRunner.loginPage.clickLoginButton();

    }
//    @When("The user enters the username {string}")
//    public void the_user_enters_the_username(String username) {
//        TestRunner.loginPage.enterUsername(username);
//
//    }
//
//    @When("The user enters the password {string}")
//    public void the_user_enters_the_password(String password) {
//        TestRunner.loginPage.enterPassword(password);

    }

