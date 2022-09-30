package com.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.base.ConfProperties;
import com.example.base.HomePage;
import com.example.core.BaseTest;
import com.example.core.SignInInterface;
import org.testng.Assert;
import org.testng.annotations.*;

public class ChangePasswordPageTest extends BaseTest implements SignInInterface {
    private HomePage homePage;
    private ChangePasswordPage changePasswordPage;

    @BeforeClass
    public void initialization() {
        //init classes
        homePage = new HomePage(driver);
        changePasswordPage = new ChangePasswordPage(driver);

        signIn(ConfProperties.getProperty("email"), ConfProperties.getProperty("password"), driver);
        homePage.clickOnMyAccountLink();
    }

    @Test
    public void testOpenPage(){
        ExtentTest testOpenPage = extent.createTest("Open 'Change password' page test");

        changePasswordPage.openPage();
        String expectedTitle = "Change password | ASOS";
        String originalTitle = driver.getTitle();

        Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match\"");
        testOpenPage.log(Status.PASS, "Opened successfully");
    }

    @Test
    public void testChangePassword() {
        ExtentTest testChangePassword = extent.createTest("Change password test");

        changePasswordPage.openPage();
        changePasswordPage.changePassword(
                "aitu123456789",
                "ernar123456789"
        );

        testChangePassword.log(Status.PASS, "Password changed successfully");
    }
}
