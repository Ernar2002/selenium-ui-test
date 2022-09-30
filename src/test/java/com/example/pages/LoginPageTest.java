package com.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.base.HomePage;
import com.example.core.BaseTest;
import com.example.listener.RetryAnalyzer;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void initialization(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(retryAnalyzer= RetryAnalyzer.class)
    public void signInTest() {
        ExtentTest sigInTest = extent.createTest("Sign In test");
        homePage.clickOnSignInLink();
        loginPage.signIn("infinity.aitu@gmail.com", "aitu123456789");

        sigInTest.log(Status.PASS, "Successfully joined");
    }

    @Test(retryAnalyzer= RetryAnalyzer.class)
    public void test() {

    }

    @Test
    public void signOutTest() {
        homePage.clickOnSignOutBtn();

        Assert.assertFalse(driver.findElement(By.xpath("//button[@data-testid='signout-link']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//button[@data-testid='signout-link']")).isDisplayed());
    }

    @Test(retryAnalyzer= RetryAnalyzer.class)
    public void falseSignInTest() {
        homePage.clickOnSignInLink();
        loginPage.signIn("infinity.aitu@gmail.com", "aitu");

        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='signin']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='signin']")).isDisplayed());
    }

}
