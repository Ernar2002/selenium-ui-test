package com.example.browser;

import com.example.base.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

    WebDriver driver;
    @Test
    @Parameters( {"BrowserType"} )
    public void testExamplePageOnMultipleBrowsers (String browserType) {
        if (browserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("firefoxdriver"));
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("homePage"));
    }
}
