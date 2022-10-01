package com.example.pages.actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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
        ExtentTest testClass008 = extent.createTest("Test008");
        //TC008
        filterAction.clickOnProductType();
        testClass008.log(Status.PASS, "Success");
    }
    @Test
    public void testClass009(){
        ExtentTest testClass009 = extent.createTest("Test009");

        //TC009
        filterAction.clickOnSortBtn();
        testClass009.log(Status.PASS, "Success");

    }

    @Test
    public void testClass010(){
        ExtentTest testClass010 = extent.createTest("Test010");
        //TC010
        filterAction.clickOnNewInDateBtn();
        testClass010.log(Status.PASS, "Success");

    }

    @Test
    public void testClass011(){
        ExtentTest testClass011 = extent.createTest("testClass011");
        //TC011
        filterAction.clickOnBrandBtn();
        testClass011.log(Status.PASS, "Success");

    }
}

