package com.example.pages.actions;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterAction  {

    private WebDriver driver;

    private WebDriverWait wait;

    public FilterAction(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//button[@data-id=\"e87ba617-daa1-4b64-8f36-ab92e61283f7\"]")
    private WebElement clothingDropDownBtn;

    @FindBy(xpath = "//a[@href=\"https://www.asos.com/men/t-shirts-vests/cat/?cid=7616#nlid=mw|clothing|shop+by+product|t-shirts+%26+vests\"]")
    private WebElement clothingLink;

    @FindBy(xpath = "//li[@data-dropdown-id=\"attribute_1047\"]")
    private WebElement productTypeBtn;

    @FindBy(xpath = "//*[@id=\"mediumRefinements\"]/li[3]/div/div/div/ul/li[1]/div")
    private WebElement productTypeInput;

    @FindBy(xpath = "//*[@id=\"mediumRefinements\"]/li[1]/div/button")
    private WebElement sortBtn;

    @FindBy(xpath = "//li[@id=\"plp_web_sort_price_high_to_low\"]")
    private WebElement sortTypeInput;

    @FindBy(xpath = "//*[@id=\"mediumRefinements\"]/li[2]/div/button")
    private WebElement newInDateBtn;

    @FindBy(xpath = "//*[@id=\"mediumRefinements\"]/li[2]/div/div/div/ul/li[1]/div/label/div")
    private WebElement newInDateInput;

    @FindBy(xpath = "//li[@data-dropdown-id=\"brand\"]")
    private WebElement brandBtn;

    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    private WebElement searchInput;


    @FindBy(xpath = "//*[@id=\"men-floor\"]")
    private WebElement menBtn;



    public void goToHomePage(){
        wait.until(ExpectedConditions.visibilityOf(menBtn));
        menBtn.click();
    }

    //Go to clothing page
    public void clickOnClothingType(){
        wait.until(ExpectedConditions.visibilityOf(clothingDropDownBtn));
        clothingDropDownBtn.click();
        wait.until(ExpectedConditions.visibilityOf(clothingLink));
        clothingLink.click();
    }

    //Test case 008
    public void clickOnProductType(){
        //Click on Product type button
        wait.until(ExpectedConditions.visibilityOf(productTypeBtn));
        productTypeBtn.click();
        //Click on Product type option
        wait.until(ExpectedConditions.visibilityOf(productTypeInput));
        productTypeInput.click();
    }

    //Test case 009
    public void clickOnSortBtn(){
        //Click on sort button
        wait.until(ExpectedConditions.visibilityOf(sortBtn));
        sortBtn.click();
        //Choose Price high to low sorting option
        wait.until(ExpectedConditions.visibilityOf(sortTypeInput));
        sortTypeInput.click();
    }

    //Test case 010
    public void clickOnNewInDateBtn(){
        //Click on New in date button
        wait.until(ExpectedConditions.visibilityOf(newInDateBtn));
        newInDateBtn.click();
        //Choose today's releases
        wait.until(ExpectedConditions.visibilityOf(newInDateInput));
        newInDateInput.click();
    }

    //Test case 011
    @SneakyThrows
    public void clickOnBrandBtn(){
        //Click on Brand button
        wait.until(ExpectedConditions.visibilityOf(brandBtn));
        brandBtn.click();
        //Click on Search input
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.click();
        //Type in Asus which is not clothing brand, see "No matches"
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys("Asus");
    }


}
