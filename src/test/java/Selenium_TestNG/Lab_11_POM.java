package Selenium_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Lab_11_POM {
    WebDriver driver;

    // Constructor
    public Lab_11_POM(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By desktopsLink = By.linkText("Desktops");
    By macLink = By.linkText("Mac (1)");
    By sortDropdown = By.id("input-sort");
    By nameAZOption = By.xpath("//option[contains(text(),'Name (A - Z)')]");
    By addToCartButton = By.xpath("//button[contains(@onclick,'cart.add')]");
    By searchBox = By.name("search");
    By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");
    By descriptionCheckbox = By.name("description");

    // Methods
    public void goToMacSection() {
        driver.findElement(desktopsLink).click();
        driver.findElement(macLink).click();
    }

    public void sortByNameAZ() {
        WebElement sort = driver.findElement(sortDropdown);
        sort.click();
        driver.findElement(nameAZOption).click();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void searchProduct(String searchItem) {
        WebElement box = driver.findElement(searchBox);
        box.clear();
        box.sendKeys(searchItem);
        driver.findElement(searchButton).click();
    }

    public void searchWithDescription(String searchItem) {
        WebElement box = driver.findElement(searchBox);
        box.clear();
        box.sendKeys(searchItem);
        driver.findElement(descriptionCheckbox).click();
        driver.findElement(searchButton).click();
    }
}
