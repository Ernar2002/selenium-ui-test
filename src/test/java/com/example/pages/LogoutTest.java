package com.example.pages;

import com.example.base.HomePage;
import com.example.core.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    public void initialization(){
        homePage = new HomePage(driver);
    }

    @Test
    public void signOutTest() {
        homePage.clickOnSignOutBtn();

        Assert.assertFalse(driver.findElement(By.xpath("//button[@data-testid='signout-link']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//button[@data-testid='signout-link']")).isDisplayed());
    }
}
