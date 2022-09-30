package com.example.pages.actions;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//a[@data-analytics-id=\"roe-mwgbl-winteressentials-mulink\"]")
    public WebElement showProducts;
    @FindBy(xpath = "//button[@class=\"mm1gcXw\"]")
    public List<WebElement> addToFavorites;
    @FindBy(xpath = "//a[@aria-label=\"Saved Items\"]")
    public WebElement myFavorites;
    @FindBy(xpath = "//button[@aria-label=\"Delete\"]")
    public List<WebElement> deleteMyFavorites;

    public void addProductToFavorites(int index) {
       //Click to see the products
        wait.until(ExpectedConditions.visibilityOf(showProducts));
        showProducts.click();
        //Add 3 products to favorites
        wait.until(ExpectedConditions.visibilityOf(addToFavorites.get(1)));
        WebElement category = addToFavorites.get(index);
        category.click();
        wait.until(ExpectedConditions.visibilityOf(myFavorites));
        myFavorites.click();
        }

    public void deleteFromFavorites(int index){
        wait.until(ExpectedConditions.visibilityOf(myFavorites));
        myFavorites.click();
        //Delete all favorites
        for(WebElement delete : deleteMyFavorites){
           delete.click();
       }
    }
}