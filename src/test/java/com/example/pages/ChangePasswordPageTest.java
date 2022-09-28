package com.example.pages;

import com.example.base.HomePage;
import com.example.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class ChangePasswordPageTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private ChangePasswordPage changePasswordPage;

    @BeforeClass
    public void setUp(){
       //init classes
       homePage = new HomePage(driver);
       loginPage = new LoginPage(driver);
       changePasswordPage = new ChangePasswordPage(driver);

        //firstly we should sign in
       homePage.clickOnSignInLink();
       loginPage.signIn("infinity.aitu@gmail.com", "aitu123456789");

       //open profile page
       homePage.clickOnMyAccountLink();
    }

    @Test
    public void testOpenPage(){
        changePasswordPage.openPage();
        String expectedTitle = "Change password | ASOS";
        String originalTitle = driver.getTitle();

        Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match\"");
    }

    @Test
    public void testChangePassword() {
        changePasswordPage.openPage();
        changePasswordPage.changePassword(
                "aitu123456789",
                "ernar123456789"
        );
    }
}
