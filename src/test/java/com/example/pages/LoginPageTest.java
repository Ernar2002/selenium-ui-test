package com.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.base.ConfProperties;
import com.example.base.HomePage;
import com.example.core.BaseTest;
import com.example.core.SignInInterface;
import com.example.listener.RetryAnalyzer;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest implements SignInInterface {
    private HomePage homePage;

    @BeforeClass
    public void initialization(){
        homePage = new HomePage(driver);
    }

    @Test
    public void signInTest() {
        ExtentTest sigInTest = extent.createTest("Sign In test");
        signIn(ConfProperties.getProperty("email"), ConfProperties.getProperty("password"), driver);

        sigInTest.log(Status.PASS, "Successfully joined");
    }

}
