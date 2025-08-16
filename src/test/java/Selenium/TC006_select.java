package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006_select {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub\WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		if(driver.findElement(By.id("email_create")).isDisplayed()) {
			System.out.println("email is displayed");
		driver.findElement(By.id("email_create")).clear();	
		
		driver.findElement(By.id("email_create")).sendKeys("venkay@gmail.com");
		driver.findElement(By.id("email_create")).sendKeys(Keys.TAB);
		driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);	
		}
		else {
			System.out.println("email is created");
		}
		Thread.sleep(3000);
		driver.findElement(By.id("id_gender1")).click();
		if (driver.findElement(By.id("id_gender1")).isSelected()) {
			System.out.println("is selected");
		}
		else {
			System.out.println("not selected");
		}
		driver.findElement(By.id("id_gender1")).sendKeys(Keys.TAB);
		driver.findElement(By.id("customer_firstname")).sendKeys("TUMMALA");
		driver.findElement(By.id("customer_firstname")).sendKeys(Keys.TAB);
		driver.findElement(By.id("customer_lastname")).sendKeys("VENKATESH");
		driver.findElement(By.id("customer_lastname")).sendKeys(Keys.TAB);
		driver.findElement(By.id("email")).sendKeys(Keys.TAB);
		driver.findElement(By.id("passwd")).sendKeys("pass@123");
		driver.findElement(By.id("passwd")).sendKeys(Keys.TAB);
		driver.findElement(By.id("days")).sendKeys("15");
		driver.findElement(By.id("days")).sendKeys(Keys.TAB);
		driver.findElement(By.id("months")).sendKeys("October");
		driver.findElement(By.id("months")).sendKeys(Keys.TAB);
		driver.findElement(By.id("years")).sendKeys("2002");
		driver.findElement(By.id("years")).sendKeys(Keys.TAB);
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("newsletter")).sendKeys(Keys.TAB);
		driver.findElement(By.id("submitAccount")).click();
		
	}

	
}
