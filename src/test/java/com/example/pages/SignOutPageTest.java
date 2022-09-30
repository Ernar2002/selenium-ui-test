package com.example.pages;

import com.example.base.ConfProperties;
import com.example.base.HomePage;
import com.example.core.BaseTest;
import com.example.core.SignInInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignOutPageTest extends BaseTest implements SignInInterface {

    private HomePage homePage;

    @BeforeClass
    public void initialization(){
        homePage = new HomePage(driver);
        signIn(ConfProperties.getProperty("email"), ConfProperties.getProperty("password"), driver);
    }

    @Test
    public void signOutTest() {
        homePage.clickOnSignOutBtn();

        wait.until(ExpectedConditions.visibilityOf(homePage.myAccountDropDownBtn));
        homePage.myAccountDropDownBtn.click();
        wait.until(ExpectedConditions.visibilityOf(homePage.signInLink));
        Assert.assertTrue(homePage.signInLink.isDisplayed());
    }
}
