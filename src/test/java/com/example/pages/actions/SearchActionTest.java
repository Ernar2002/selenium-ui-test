package com.example.pages.actions;

import com.example.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        searchAction.search("nike shoes");

        WebElement foundCount = driver.findElement(By.xpath("//p[@data-auto-id = 'styleCount']"));

        Assert.assertTrue(foundCount.isDisplayed(), "NOTHING MATCHES YOUR SEARCH");
    }

    @Test
    public void searchForInvalidProductName() {
        searchAction.search("shakalaka");

        WebElement message = driver.findElement(By.cssSelector(".grid-text__container .grid-text__title"));
        String text = message.getText();

        Assert.assertEquals("NOTHING MATCHES YOUR SEARCH", text);
    }
}
