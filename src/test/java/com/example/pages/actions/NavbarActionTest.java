package com.example.pages.actions;

import com.example.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        navbarAction.redirectToItemInCategory(0);

//        WebElement foundCount = driver.findElement(By.xpath("//p[@data-auto-id = 'styleCount']"));

//        Assert.assertTrue(foundCount.isDisplayed(), "NOTHING MATCHES YOUR SEARCH");
    }

}
