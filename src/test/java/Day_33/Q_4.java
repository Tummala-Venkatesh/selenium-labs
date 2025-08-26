package Day_33;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q_4 {
	WebDriver driver;
  @Test
  public void f() {
	  
	  WebElement dropdown = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]")); 
	  Select select = new Select(dropdown);
	  select.selectByValue("2");

  }
  
  @BeforeMethod
  public void BeforeMethod() {
	  driver=new FirefoxDriver();
	  driver.get("https://www.selenium.dev/selenium/web/web-form.html");
	  
  }
}
