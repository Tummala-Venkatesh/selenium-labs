package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC008_alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.findElement(By.id("accept")).click();
		Alert salert=driver.switchTo().alert();
		System.out.println("the message is:"+salert.getText());
		salert.accept();
		driver.findElement(By.id("confirm")).click();
		Alert calert=driver.switchTo().alert();
		System.out.println("the message is:"+calert.getText());
		calert.dismiss();
		driver.findElement(By.id("prompt")).click();
		Alert palert=driver.switchTo().alert();
		System.out.println("the message is:"+palert.getText());
		palert.accept();
	}

}
