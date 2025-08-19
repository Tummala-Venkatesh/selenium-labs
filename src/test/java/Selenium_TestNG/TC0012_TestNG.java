package Selenium_TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC0012_TestNG {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException {
	   
		/*String title=driver.getTitle();
		//System.out.println("The Title is:"+title);
		System.out.println("Test class");
		Thread.sleep(3000);
		//WebElement username=driver.findElement(By.name("username"));
		//username.sendKeys("Admin");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();*/
	  System.out.println("Test class");

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      // Wait until elements are visible and interact
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(password);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	    WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    System.out.println("before method"); 
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method");
	  //driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "tummala", "admin123" },
      //new Object[] { "venkatesh", "Admin@123" },
     // new Object[] { "rahul", "admin123" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite");
  }

}
