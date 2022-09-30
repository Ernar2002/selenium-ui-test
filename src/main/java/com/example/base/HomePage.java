package com.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    public WebElement myAccountDropDownBtn;

    @FindBy(xpath = "//button[@data-id=\"e87ba617-daa1-4b64-8f36-ab92e61283f7\"]")
    public WebElement clothingDropDownBtn;

    @FindBy(xpath = "//a[@href=\"https://www.asos.com/men/t-shirts-vests/cat/?cid=7616#nlid=mw|clothing|shop+by+product|t-shirts+%26+vests\"]")
    public WebElement clothingLink;

    @FindBy(xpath = "//*[@id=\"mediumRefinements\"]/li[4]/div/button")
    public WebElement productTypeBtn;

    @FindBy(xpath = "//input[@id=\"attribute_1047_8415\"]")
    public WebElement productTypeInput;

    @FindBy(xpath = "//*[@id=\"mediumRefinements\"]/li[1]/div/button")
    public WebElement sortBtn;

    @FindBy(xpath = "//li[@id=\"plp_web_sort_price_high_to_low\"]")
    public WebElement sortTypeInput;

    @FindBy(xpath = "//*[@id=\"mediumRefinements\"]/li[2]/div/button")
    public WebElement newInDateBtn;

    @FindBy(xpath = "//input[@id=\"freshness_band_1\"]")
    public WebElement newInDateInput;

    @FindBy(xpath = "//*[@id=\"mediumRefinements\"]/li[7]/div/button")
    public WebElement brandBtn;

    @FindBy(xpath = "//input[@class=\"LYG4Zpk\"]")
    public WebElement searchInput;


    @FindBy(xpath = "//a[@data-testid='signin-link']")
    public WebElement signInLink;

    @FindBy(xpath = "//button[@data-testid='signout-link']")
    public WebElement signOutBtn;

    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    public WebElement myAccountLink;

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

    public void clickOnSignInLink(){
        wait.until(ExpectedConditions.visibilityOf(myAccountDropDownBtn));
        myAccountDropDownBtn.click();
        wait.until(ExpectedConditions.visibilityOf(signInLink));
        signInLink.click();
    }

    public void clickOnMyAccountLink(){
        wait.until(ExpectedConditions.visibilityOf(myAccountDropDownBtn));
        myAccountDropDownBtn.click();
        wait.until(ExpectedConditions.visibilityOf(myAccountLink));
        myAccountLink.click();
    }

    public void clickOnSignOutBtn(){
        wait.until(ExpectedConditions.visibilityOf(myAccountDropDownBtn));
        myAccountDropDownBtn.click();
        wait.until(ExpectedConditions.visibilityOf(signOutBtn));
        signOutBtn.click();
    }
}
