package Selenium_TestNG;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		  Properties prob=new Properties();
          FileInputStream fis = new FileInputStream("D:\\java\\aug\\src\\test\\java\\Selenium_TestNG\\Lab12.properties");
          prob.load(fis);
          String url=prob.getProperty("url");
          String firstname=prob.getProperty("firstname");
          String lastname=prob.getProperty("lastname");
          String email=prob.getProperty("email");
          String telephone=prob.getProperty("telephone");
          String password=prob.getProperty("password");
          String con_password=prob.getProperty("con_password");
 
 
		
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.get(url);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  String title=driver.getTitle();
		  System.out.println("The Title is:"+title);
		  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	        // click on Register
	      driver.findElement(By.linkText("Register")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.id("input-firstname")).sendKeys(firstname);
	      driver.findElement(By.id("input-lastname")).sendKeys(lastname);
	      driver.findElement(By.id("input-email")).sendKeys(email);
	      driver.findElement(By.id("input-telephone")).sendKeys(telephone);
	      driver.findElement(By.id("input-password")).sendKeys(password);
	      driver.findElement(By.id("input-confirm")).sendKeys(con_password);

	        // Newsletters
	      driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
	      driver.findElement(By.name("agree")).click();
	      driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();

	}

}
