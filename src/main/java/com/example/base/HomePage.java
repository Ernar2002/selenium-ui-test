package com.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    public WebElement myAccountDropDownBtn;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    public WebElement signInLink;

    @FindBy(xpath = "//button[@data-testid='signout-link']")
    public WebElement signOutBtn;

    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    public WebElement myAccountLink;

    public void clickOnSignInLink(){
        wait.until(ExpectedConditions.visibilityOf(myAccountDropDownBtn));
        myAccountDropDownBtn.click();
        wait.until(ExpectedConditions.visibilityOf(signInLink));
        signInLink.click();
    }

    public void clickOnMyAccountLink(){
        wait.until(ExpectedConditions.visibilityOf(myAccountDropDownBtn));
        myAccountDropDownBtn.click();
        wait.until(ExpectedConditions.visibilityOf(myAccountLink));
        myAccountLink.click();
    }

    public void clickOnSignOutBtn(){
        wait.until(ExpectedConditions.visibilityOf(myAccountDropDownBtn));
        myAccountDropDownBtn.click();
        wait.until(ExpectedConditions.visibilityOf(signOutBtn));
        signOutBtn.click();
    }
}
