package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		
		WebElement sort = driver.findElement(By.id("input-sort"));
		Select sec = new Select(sort);
		//sec.selectByIndex(5);
		
		List<WebElement> elecount=sec.getOptions(); 
		for (int i=0;i<elecount.size();i++) {
			System.out.println("the element:"+elecount.get(i).getText());
		}

	}

}
