package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='EmailAddress']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInBtn;

    public LoginPage typeEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public void signIn(String email, String password){
        typeEmail(email);
        typePassword(password);
        signInBtn.click();
    }
}
