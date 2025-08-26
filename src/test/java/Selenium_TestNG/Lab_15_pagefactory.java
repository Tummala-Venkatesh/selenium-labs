package Selenium_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lab_15_pagefactory {

    WebDriver driver;

    // Constructor
    public Lab_15_pagefactory(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    // Actions
    public void enterusername(String uname) {
        usernameField.sendKeys(uname);
    }

    public void enterpassword(String pwd) {
        passwordField.sendKeys(pwd);
    }

    public void clickonlogin() {
        loginButton.click();
    }
}
