package Day_33;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q_2 {
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver.findElement(By.id("username")).click();
	  driver.findElement(By.id("username")).sendKeys("tomsmith");
	  driver.findElement(By.id("username")).sendKeys(Keys.TAB);
	  driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i")).click();
	  
	  WebElement suc= driver.findElement(By.id("flash"));
	  
	  if(suc.getText().contains("You logged into a secure area!")) {
		  System.out.println("Login success");
	  }else {
		  System.out.println("Login failed");
	  }
	  
	  
  }
  @BeforeMethod
  public void BeforeMethod() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("https://the-internet.herokuapp.com/login");
	  Thread.sleep(3000);
	  
  }
}
