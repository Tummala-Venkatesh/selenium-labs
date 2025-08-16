package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");
		String title=driver.getTitle();
		if(title.equals("OpenCart - Open Source Shopping Cart Solution")) {
			System.out.println("Matched");
		}else {
			System.out.println("Un Matched");
		}
		driver.navigate().to("https://in.search.yahoo.com/?fr2=inr");
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		driver.navigate().refresh();
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("page source is:"+driver.getPageSource());
		
		

	}

}
