package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
	    WebDriver driver = new FirefoxDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		//sign in
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("Login")).click();		
		driver.findElement(By.id("input-email")).sendKeys("Verify@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Verify@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
			
		//components,moniters
		driver.findElement(By.linkText("Components")).click();
		driver.findElement(By.linkText("Monitors (2)")).click();
		//show dropdown
		WebElement show= driver.findElement(By.id("input-limit"));
		Select sow=new Select(show);
		sow.selectByIndex(1);
		//add to cart
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();
		Thread.sleep(3000);
		//specification display
		WebElement specdis=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[2]/a"));
		specdis.click();
		if (specdis.isDisplayed()) {
			System.out.println("it is displayed");
		}
		else {
			System.out.println("it not displayed");
		}
		//add to wishlist
		WebElement wishlist=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]/i"));
		wishlist.click();
		Thread.sleep(3000);
		//mobile search
		driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/input")).sendKeys("Mobile");
		//search
		driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/span/button")).click();
		//checkbox
		driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
		//click on button
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		//click on HTC Mobile
		driver.findElement(By.linkText("HTC Touch HD")).click();
		//change number
		WebElement changenum=driver.findElement(By.id("input-quantity"));
		changenum.click();
		changenum.sendKeys(Keys.BACK_SPACE);
		changenum.sendKeys("3");
		Thread.sleep(3000);
		//add to cart
		//driver.findElement(By.id("button-cart")).click();
		WebElement addCart=driver.findElement(By.id("button-cart"));
		addCart.click();
		String cartmes=addCart.getText();
		if (cartmes.contains("Success: You have added HTC Touch HD to your shopping cart!")) {
			System.out.println("verify the message");
		}
		else {
			System.out.println("message is not verified");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/ul/li[2]/div/p/a[1]/strong")).click();
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.linkText("Continue")).click();
		
	}

}
