package com.example.pages.actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavbarActionTest extends BaseTest {

    public NavbarAction navbarAction;

    @BeforeClass
    public void initialization(){
        //init classes
        navbarAction = new NavbarAction(driver);
    }

    @Test
    public void redirectToEachDropdownCategoriesWomen() {
        ExtentTest redirectToEachDropdownCategoriesWomen = extent.createTest("redirectToEachDropdownCategoriesWomen");
        navbarAction.redirectToItemInCategory(0);

        WebElement foundCount = driver.findElement(By.xpath("//p[@data-auto-id = 'styleCount']"));
        wait.until(ExpectedConditions.visibilityOf(foundCount));

        Assert.assertTrue(foundCount.isDisplayed(), "NOTHING MATCHES YOUR SEARCH");
        redirectToEachDropdownCategoriesWomen.log(Status.PASS, "Success");
    }

}
