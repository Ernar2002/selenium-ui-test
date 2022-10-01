package com.example.pages.actions;

import com.example.base.HomePage;
import com.example.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilterActionTest extends BaseTest {

    private FilterAction filterAction;

    @BeforeClass
    public void initialization(){
        //init classes
        filterAction = new FilterAction(driver);
    }


    @BeforeMethod
    public void goToMenPage(){
        filterAction.goToHomePage();
        filterAction.clickOnClothingType();
    }

    @Test
    public void testClass008(){
        //TC008
        filterAction.clickOnProductType();
    }
    @Test
    public void testClass009(){
        //TC009
        filterAction.clickOnSortBtn();
    }

    @Test
    public void testClass010(){
        //TC010
        filterAction.clickOnNewInDateBtn();
    }

    @Test
    public void testClass011(){
        //TC011
        filterAction.clickOnBrandBtn();
    }
}

