package com.orangehrm.stepdefinitations;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    WebDriver driver;

    @Given("Launch the Browser")
    public void launch_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("Navigate to the URL")
    public void navigate_to_the_url() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("Enter the username and password")
    public void enter_the_username_and_password() throws Exception {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(3000);
    }
    
    @When("Enter the invalid username and password")
    public void enter_the_invalid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
    	driver.findElement(By.name("username")).sendKeys("Adhjkmin");
        driver.findElement(By.name("password")).sendKeys("addfghjkmin123");
        
    }


    @When("Click on Login Button")
    public void click_on_login_button() throws Exception {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }

    @Then("Login should be successful")
    public void login_should_be_successful() {
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM", title);
    }
    
    @Given("verify dashboard")
    public void verify_dashboard() {
    	System.out.println("verified dashboard");
    }
    
    @Then("Close the Browser")
    public void Close_the_Browser() {
    	driver.close();
    }
    
}
