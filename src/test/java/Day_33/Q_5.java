package Day_33;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q_5 {
	WebDriver driver;
	
  @Test
  public void f() {
	  
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/button")).click();
	  
	  Alert alert = driver.switchTo().alert();
	  System.out.println("Alert Text:"+alert.getText());
	  alert.accept();
	  
	  WebElement result = driver.findElement(By.id("result"));
	  if(result.getText().contains("You successfully clicked an alert")) {
		  System.out.println("Clicked on alert");
	  }else {
		  System.out.println("not clicked on alert");
	  }
	  
  }
  
  @BeforeMethod
  public void BeforeMethod() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  Thread.sleep(3000);
	  
  }
}
