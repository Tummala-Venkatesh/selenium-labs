package Day_33;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q_1 {
	WebDriver driver;
	
  @Test
  public void f() {
	  
	  System.out.println("Title is:"+driver.getTitle());
  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.get("https://www.google.com");
		  System.out.println("Application launched successfully");
	  }
}
