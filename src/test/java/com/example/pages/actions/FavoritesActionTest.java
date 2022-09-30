package com.example.pages.actions;

import com.example.core.BaseTest;
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
        favoritesAction.addProductToFavorites(2);
//        favoritesAction.addProductToFavorites(3);
//        favoritesAction.addProductToFavorites(4);
    }

    @Test
    public void deleteFromFavorites() {
        favoritesAction.deleteFromFavorites(0);
   }
}
