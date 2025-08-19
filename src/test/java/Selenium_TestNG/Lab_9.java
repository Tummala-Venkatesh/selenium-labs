package Selenium_TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Lab_9 {
	 WebDriver driver;
	/* @Parameters("browser")
	    @BeforeTest
	    public void setup(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        } else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        }
	    }*/
	  @Test(dataProvider = "dp")
	  public void f(String a,String b) throws InterruptedException {
		
		// Navigate to Desktops → Mac
	      driver.findElement(By.linkText("Desktops")).click();
	      driver.findElement(By.linkText("Mac (1)")).click();	      
	      WebElement sort = driver.findElement(By.id("input-sort"));
	      sort.click();
	      sort.findElement(By.xpath("//option[contains(text(),'Name (A - Z)')]")).click();

	      driver.findElement(By.xpath("//button[contains(@onclick,'cart.add')]")).click();
	      Thread.sleep(2000);   
	   
		}
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
			System.out.println("Application launched successfully");
	  }

	  @AfterMethod
	  public void afterMethod() {
		 // driver.quit();
			
	  }
	  
	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	    	new Object[] { "1","a" },
	        //new Object[] { "2","b" }
	    };
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Before Class Execution");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("After Class Execution");
	  }
      
	  @Parameters("browser")
	    @BeforeTest
	    public void setup(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        } else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        }
	    }
	  @AfterTest
	  public void afterTest() {
		  System.out.println("After Test Execution");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Before Suite Execution");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("After Suite Execution");
	  }

	}