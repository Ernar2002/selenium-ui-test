package com.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.base.ConfProperties;
import com.example.base.HomePage;
import com.example.core.BaseTest;
import com.example.core.SignInInterface;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewAccountDetailsPageTest extends BaseTest implements SignInInterface {

    private HomePage homePage;
    private ViewAccountDetailsPage viewAccountDetailsPage;

    @BeforeClass
    public void initialization (){
        //init classes
        homePage = new HomePage(driver);
        viewAccountDetailsPage = new ViewAccountDetailsPage(driver);

        //firstly we should sign in
        signIn(ConfProperties.getProperty("email"), ConfProperties.getProperty("password"), driver);

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
