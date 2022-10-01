package com.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.base.ConfProperties;
import com.example.base.HomePage;
import com.example.core.BaseTest;
import com.example.core.SignInInterface;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FalseLoginPageTest extends BaseTest implements SignInInterface {
    private HomePage homePage;

    @BeforeClass
    public void initialization(){
        homePage = new HomePage(driver);
    }

    @Test
    public void falseSignInTest() {
        ExtentTest falseSignInTest = extent.createTest("falseSignInTest");
        signIn(ConfProperties.getProperty("email"), "incorrectPassword", driver);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@id=\"loginErrorMessage\"]")).isDisplayed());
        driver.get(ConfProperties.getProperty("homePage"));

        falseSignInTest.log(Status.PASS, "Success");
    }
}
