package com.example.pages;

import com.example.base.HomePage;
import com.example.core.BaseTest;
import com.example.listener.RetryAnalyzer;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FalseLoginTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void initialization(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(retryAnalyzer= RetryAnalyzer.class)
    public void falseSignInTest() {
        homePage.clickOnSignInLink();
        loginPage.signIn("infinity.aitu@gmail.com", "aitu");

        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='signin']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='signin']")).isDisplayed());
    }
}
