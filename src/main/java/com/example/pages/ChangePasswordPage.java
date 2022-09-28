package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ChangePasswordPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//span[text()='Change password']")
    private WebElement changePasswordIcon;

    @FindBy(xpath = "//input[@name='existingPassword']")
    private WebElement existingPasswordField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    private ChangePasswordPage typeExistingPassword(String existingPassword){
        existingPasswordField.sendKeys(existingPassword);
        return this;
    }

    private ChangePasswordPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public void openPage(){
        wait.until(ExpectedConditions.visibilityOf(changePasswordIcon));
        changePasswordIcon.click();
    }

    public void changePassword(String existingPassword,
                               String password){
        wait.until(ExpectedConditions.visibilityOf(existingPasswordField));
        typeExistingPassword(existingPassword);
        typePassword(password);
        submitBtn.click();
    }
}
