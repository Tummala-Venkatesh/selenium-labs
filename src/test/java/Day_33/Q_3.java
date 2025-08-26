package Day_33;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q_3 {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  
	  Thread.sleep(3000);
	  
	  List<WebElement> Top_5 = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));
	  
	  for(int i=0; i<5 && i< Top_5.size();i++) {
		  System.out.println((i+1)+"."+ Top_5.get(i).getText());
		  
	  }
	  
  }
  
  @BeforeMethod
  public void BeforeMethod() {
	  WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
	  driver.get("https://www.amazon.in/");
	  
  }
  
}
