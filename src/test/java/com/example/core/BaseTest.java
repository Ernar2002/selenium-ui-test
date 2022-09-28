package com.example.core;

import com.example.base.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void initialization(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("homePage"));
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
