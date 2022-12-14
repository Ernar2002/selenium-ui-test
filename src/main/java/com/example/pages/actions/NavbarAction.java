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

public class NavbarAction {
    private WebDriver driver;

    private WebDriverWait wait;

    private Actions actions;

    public NavbarAction(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//span[text() = 'SHOP MEN']")
    private WebElement goToMenPage;

    @FindBy(xpath = "(//nav[@aria-label=\"Men's products\"])[2]//child::button")
    private List<WebElement> navbarCategories;

    @FindBy(xpath = "(//a[@data-first=\"true\"])[15]")
    private WebElement firstItem;

    public void redirectToItemInCategory(int index) {
        // Click to see men's products
        wait.until(ExpectedConditions.visibilityOf(goToMenPage));
        goToMenPage.click();
        // get the element
        wait.until(ExpectedConditions.visibilityOfAllElements(navbarCategories));
        WebElement category = navbarCategories.get(index);
        // mouse over the element
        actions.moveToElement(category).perform();
        wait.until(ExpectedConditions.visibilityOf(firstItem));
        firstItem.click();
    }


}
