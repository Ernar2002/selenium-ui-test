package com.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.base.HomePage;
import com.example.core.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewOwnOrdersPageTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private ViewOwnOrdersPage viewOwnOrdersPage;

    @BeforeClass
    public void initialization(){
        //init classes
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        viewOwnOrdersPage = new ViewOwnOrdersPage(driver);

        //firstly we should sign in
        homePage.clickOnSignInLink();
        loginPage.signIn("infinity.aitu@gmail.com", "aitu123456789");

        //open profile page
        homePage.clickOnMyAccountLink();
    }

    @Test
    public void viewOwnOrdersDetailTest(){
        ExtentTest viewOwnOrdersDetailTest = extent.createTest("Edit account details test");
        viewOwnOrdersPage.openPage();

        viewOwnOrdersDetailTest.log(Status.PASS, "Page opened successfully");
    }
}
