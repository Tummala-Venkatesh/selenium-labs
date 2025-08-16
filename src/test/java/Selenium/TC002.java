package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		WebElement search=driver.findElement(By.id("APjFqb"));
		search.sendKeys("Automation Testing Tools");
		Thread.sleep(3000);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		search.submit();
		
		
		//driver.findElement(By.name("btnK")).click();
		
 
		
		System.out.println("The title is:"+ driver.getTitle());
		

	}

}
