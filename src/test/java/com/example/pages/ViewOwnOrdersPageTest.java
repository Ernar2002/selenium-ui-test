package com.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.base.ConfProperties;
import com.example.base.HomePage;
import com.example.core.BaseTest;
import com.example.core.SignInInterface;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewOwnOrdersPageTest extends BaseTest implements SignInInterface {
    private HomePage homePage;
    private ViewOwnOrdersPage viewOwnOrdersPage;

    @BeforeClass
    public void initialization(){
        //init classes
        homePage = new HomePage(driver);
        viewOwnOrdersPage = new ViewOwnOrdersPage(driver);

        //firstly we should sign in
        signIn(ConfProperties.getProperty("email"), ConfProperties.getProperty("password"), driver);

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
