package com.example.core;

import com.example.base.HomePage;
import com.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public interface SignInInterface {
    default void signIn(String email, String password, WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickOnSignInLink();
        loginPage.signIn(email, password);
    }
}
