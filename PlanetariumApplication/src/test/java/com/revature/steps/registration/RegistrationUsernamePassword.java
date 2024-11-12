package com.revature.steps.registration;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationUsernamePassword {

//    @Given("The user is on the login page at URL {string}")
//    public void the_user_is_on_the_login_page_at_URL(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

//    @When("the user clicks the Registration button")
//    public void the_user_clicks_the_Registration_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

    @When("the user enters the username {string}")
    public void the_user_enters_the_username(String username) {
        TestRunner.registrationPage.enterUsernames(username);
    }

    @When("the user enters the password {string}")
    public void the_user_enters_the_password(String password) {
        TestRunner.registrationPage.enterPassword(password);
    }

    @When("The user clicks the register button")
    public void the_user_clicks_the_register_button() {
        TestRunner.registrationPage.clickRegisterButton();
    }

    @Then("Then an alert should appear {string} for {string}")
    public void then_an_alert_should_appear(String message, String docString) {
        Alert alert = TestRunner.driver.switchTo().alert();
        String alertMessage = alert.getText();
        try{
            if(message.equals("user created")){
                Assert.assertEquals("Account created successfully with username \"" + docString + "\"", alertMessage);
            } else if (message.equals("User not created")) {
                Assert.assertEquals("Account creation failed with username \"" + docString + "\"", alertMessage);
            } else{
                Assert.fail("Incorrect alert message produced: actual message: " + alertMessage);
            }
        } finally {
            alert.accept();
            TestRunner.alertWait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        }
    }

    @Then("The {string}")
    public void the(String redirectionResult) {
       if(redirectionResult.equals("User redirected to login page")){
           Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
       } else {
           Assert.assertEquals("Account Creation", TestRunner.driver.getTitle());
       }
    }

}
