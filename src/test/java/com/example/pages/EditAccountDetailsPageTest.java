package com.example.pages;

import com.example.base.HomePage;
import com.example.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditAccountDetailsPageTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private ViewAccountDetailsPage viewAccountDetailsPage;
    private EditAccountDetailsPage editAccountDetailsPage;

    @BeforeClass
    public void setUp(){
        //init classes
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        editAccountDetailsPage = new EditAccountDetailsPage(driver);
        viewAccountDetailsPage = new ViewAccountDetailsPage(driver);

        //firstly we should sign in
        homePage.clickOnSignInLink();
        loginPage.signIn("infinity.aitu@gmail.com", "aitu123456789");

        //open profile page
        homePage.clickOnMyAccountLink();
    }

    @Test
    public void testOpenPage(){
        viewAccountDetailsPage.openPage();

        String expectedTitle = "My details | ASOS";
        String originalTitle = driver.getTitle();

        Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match\"");
    }

    @Test
    public void testEditDetails(){
        viewAccountDetailsPage.openPage();
        editAccountDetailsPage.editDetails("Yernar",
                "Yerzhan",
                "infinity.aitu@gmail.com",
                "Menswear",
                1,
                12,
                2002);
    }
}
