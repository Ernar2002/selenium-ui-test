package com.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.base.HomePage;
import com.example.core.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewAccountDetailsPageTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private ViewAccountDetailsPage viewAccountDetailsPage;

    @BeforeClass
    public void initialization (){
        //init classes
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        viewAccountDetailsPage = new ViewAccountDetailsPage(driver);

        //firstly we should sign in
        homePage.clickOnSignInLink();
        loginPage.signIn("infinity.aitu@gmail.com", "aitu123456789");

        //open profile page
        homePage.clickOnMyAccountLink();
    }

    @Test
    public void viewAccountsDetailTest(){
        ExtentTest viewAccountDetailsTest = extent.createTest("Edit account details test");

        viewAccountDetailsPage.openPage();
        viewAccountDetailsTest.log(Status.PASS, "Page opened successfully");
    }
}
