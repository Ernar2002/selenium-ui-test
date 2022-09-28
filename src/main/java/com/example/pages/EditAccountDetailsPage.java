package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditAccountDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public EditAccountDetailsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='emailAddress']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//span[text()='Menswear']")
    private WebElement mostlyInterestedIn;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//select[@id='datepicker_day_select']")
    private WebElement daysSelect;

    @FindBy(xpath = "//select[@id='datepicker_month_select']")
    private WebElement monthsSelect;

    @FindBy(xpath = "//select[@id='datepicker_year_select']")
    private WebElement yearsSelect;

    public EditAccountDetailsPage typeFirstName(String firstName){
        firstNameField.sendKeys(firstName);
        return this;
    }

    public EditAccountDetailsPage typeLastName(String lastName){
        lastNameField.sendKeys(lastName);
        return this;
    }

    public EditAccountDetailsPage typeEmailAddress(String email){
        emailAddressField.sendKeys(email);
        return this;
    }

    public void chooseInterested(String interested){
        mostlyInterestedIn.click();
    }

    public void selectBirthdayDay(int day){
        Select select = new Select(daysSelect);
        select.selectByValue(Integer.toString(day));
    }

    public void selectBirthdayMonth(int month){
        Select select = new Select(monthsSelect);
        select.selectByIndex(month);
    }

    public void selectBirthdayYear(int year){
        Select select = new Select(yearsSelect);
        select.selectByValue(Integer.toString(year));
    }

    public void editDetails(String firstName,
                            String lastName,
                            String email,
                            String interested,
                            int day,
                            int month,
                            int year) {
        wait(emailAddressField);
        typeFirstName(firstName);
        typeLastName(lastName);
        typeEmailAddress(email);
        chooseInterested(interested);
        selectBirthdayDay(day);
        selectBirthdayMonth(month);
        selectBirthdayYear(year);
        submitBtn.click();
    }

    public void wait(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
