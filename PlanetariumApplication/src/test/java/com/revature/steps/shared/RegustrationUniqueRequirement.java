package com.revature.steps.shared;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegustrationUniqueRequirement {

    @Given("The user is on the login page at URL {string}")
    public void the_user_is_on_the_login_page_at_URL(String url) {
        TestRunner.driver.get(url);
    }

   @When("the user clicks the Registration button")
    public void the_user_clicks_the_Registration_button() {
        TestRunner.loginPage.clickRegistrationButton();
    }

//    @When("The user enters the username {string}")
//    public void the_user_enters_the_username(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

//    @When("The user enters the password {string}")
//    public void the_user_enters_the_password(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

//    @When("The user clicks the registration button")
//    public void the_user_clicks_the_registration_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

//    @Then("Then an alert should appear {string}")
//    public void then_an_alert_should_appear(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

//    @Then("The {string}")
//    public void the(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
}
