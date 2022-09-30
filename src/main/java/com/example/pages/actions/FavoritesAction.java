package com.example.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FavoritesAction {
    private WebDriver driver;

    private WebDriverWait wait;

    private Actions actions;

    public FavoritesAction(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//span[text() = 'SHOP MEN']")
    private WebElement goToMenPage;
    @FindBy(xpath = "//a[@data-analytics-id=\"roe-mwgbl-winteressentials-mulink\"]")
    private WebElement winterProducts;
    @FindBy(xpath = "//button[@class=\"mm1gcXw\"]")
    private List<WebElement> addToFavorites;
    @FindBy(xpath = "//a[@aria-label=\"Saved Items\"]")
    private WebElement myFavoritesIcon;
    @FindBy(xpath = "//*[@id=\"saved-lists-app\"]/main/div/div[1]/section/ol//child::li")
    private List<WebElement> savedFavorites;

    public void addProductToFavoritesWithCount(int count) {
        //Click to see men's products
        wait.until(ExpectedConditions.visibilityOf(goToMenPage));
        goToMenPage.click();
        //Click to see the winter products
        wait.until(ExpectedConditions.visibilityOf(winterProducts));
        winterProducts.click();
        //Add 3 products to favorites
        wait.until(ExpectedConditions.visibilityOfAllElements(addToFavorites));
        for (int i = 0; i < count; i++) {
            WebElement category = addToFavorites.get(i);
            category.click();
        }

        wait.until(ExpectedConditions.visibilityOf(myFavoritesIcon));
        myFavoritesIcon.click();
    }

    public int savedSize() {
        wait.until(ExpectedConditions.visibilityOfAllElements(savedFavorites));
        return savedFavorites.size();
    }
}