package Day_33;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;


public class Q_6 {
	WebDriver driver;
  @Test
  public void f() {
	  
	  WebElement c1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]"));
      WebElement c2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]"));

      if (!c1.isSelected()) {
          c1.click();
      }
      if (!c2.isSelected()) {
          c2.click();
      }

      if (c1.isSelected() && c2.isSelected()) {
          System.out.println("Both checkboxes are selected.");
      } else {
          System.out.println("Some checkboxes are not selected.");
      }
  }
  
  @BeforeMethod
  public void BeforeMethod() {
	  driver=new FirefoxDriver();
	  driver.get("https://the-internet.herokuapp.com/checkboxes");
	  
  }
}
