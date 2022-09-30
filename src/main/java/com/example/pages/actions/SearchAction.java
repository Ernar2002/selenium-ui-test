package com.example.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchAction {
    private WebDriver driver;
    private WebDriverWait wait;
    public SearchAction(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//input[@data-testid='search-input']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    private void typeSearchInput(String text) {
        searchInput.sendKeys(text);
    }

    public void search(String text) {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        typeSearchInput(text);
        searchButton.click();
    }

}
