package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewOwnOrdersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ViewOwnOrdersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//span[text()='My orders']")
    private WebElement myOrdersIcon;

    public void openPage() {
        wait.until(ExpectedConditions.visibilityOf(myOrdersIcon));
        myOrdersIcon.click();
    }
}
