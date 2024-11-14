package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "usernameInput")
    private WebElement loginUsernameInput;

    @FindBy(id = "passwordInput")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//form/input[3]")
    private WebElement loginButton;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterUsername(String username){
        loginUsernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        loginPasswordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }






}
