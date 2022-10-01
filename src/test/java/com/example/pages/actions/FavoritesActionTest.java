package com.example.pages.actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FavoritesActionTest extends BaseTest {

    public FavoritesAction favoritesAction;

    @BeforeClass
    public void initialization(){
        //init classes
        favoritesAction = new FavoritesAction(driver);
    }

    @Test
    public void addProductToFavorites() {
        ExtentTest addProductToFavorites = extent.createTest("add Product To Favorites test");

        int amount = 8;

        favoritesAction.addProductToFavoritesWithCount(amount);

        Assert.assertEquals(amount, favoritesAction.savedSize());

        addProductToFavorites.log(Status.PASS, "Product added to favorites successfully");
    }

}
