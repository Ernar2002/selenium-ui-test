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

public class SearchActionTest extends BaseTest {

    public SearchAction searchAction;

    @BeforeClass
    public void initialization(){
        //init classes
        searchAction = new SearchAction(driver);
    }

    @Test
    public void searchForNikeShoes() {
        ExtentTest searchForNikeShoes = extent.createTest("searchForNikeShoes");
        searchAction.search("nike shoes");

        WebElement foundCount = driver.findElement(By.xpath("//p[@data-auto-id = 'styleCount']"));
        wait.until(ExpectedConditions.visibilityOf(foundCount));

        Assert.assertTrue(foundCount.isDisplayed(), "NOTHING MATCHES YOUR SEARCH");
        searchForNikeShoes.log(Status.PASS, "Success");
    }

    @Test
    public void searchForInvalidProductName() {
        ExtentTest searchForInvalidProductName = extent.createTest("searchForInvalidProductName");
        searchAction.search("shakalaka");

        WebElement message = driver.findElement(By.cssSelector(".grid-text__container .grid-text__title"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String text = message.getText();

        Assert.assertEquals("NOTHING MATCHES YOUR SEARCH", text);
        searchForInvalidProductName.log(Status.PASS, "Success");
    }
}
