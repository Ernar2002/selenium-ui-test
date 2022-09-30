package com.example.pages.actions;

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
        int amount = 8;

        favoritesAction.addProductToFavoritesWithCount(amount);

        Assert.assertEquals(amount, favoritesAction.savedSize());
    }

}
