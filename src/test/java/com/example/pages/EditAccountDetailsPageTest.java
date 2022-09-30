package com.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.base.ConfProperties;
import com.example.base.HomePage;
import com.example.core.BaseTest;
import com.example.core.SignInInterface;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditAccountDetailsPageTest extends BaseTest implements SignInInterface {

    private HomePage homePage;
    private ViewAccountDetailsPage viewAccountDetailsPage;
    private EditAccountDetailsPage editAccountDetailsPage;

    @BeforeClass
    public void initialization(){
        //init classes
        homePage = new HomePage(driver);
        editAccountDetailsPage = new EditAccountDetailsPage(driver);
        viewAccountDetailsPage = new ViewAccountDetailsPage(driver);

        //firstly we should sign in
        signIn(ConfProperties.getProperty("email"), ConfProperties.getProperty("password"), driver);

        //open profile page
        homePage.clickOnMyAccountLink();
    }

    @Test
    public void testOpenPage(){
        ExtentTest testOpenPage = extent.createTest("Open 'My details' page test");

        viewAccountDetailsPage.openPage();

        String expectedTitle = "My details | ASOS";
        String originalTitle = driver.getTitle();

        Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match\"");
        testOpenPage.log(Status.PASS, "Opened successfully");
    }

    @Test
    public void testEditDetails(){
        ExtentTest testEditDetails = extent.createTest("Edit account details test");

        viewAccountDetailsPage.openPage();
        editAccountDetailsPage.editDetails("Yernar",
                "Yerzhan",
                "infinity.aitu@gmail.com",
                "Menswear",
                1,
                12,
                2002);

        testEditDetails.log(Status.PASS,"Data changed successfully");
    }
}
