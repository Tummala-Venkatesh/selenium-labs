package Selenium_TestNG;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC0012{
	WebDriver driver;
	String projectpath=System.getProperty("user.dir");
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException, Exception {
	  
	  String title=driver.getTitle();
	  System.out.println("The Title is:"+title);
	 // Assert.assertEquals(title, "Amazon");
	  ExtentReports extent = new ExtentReports();
	  String reportpath=projectpath+"\\Datareport.html";
	  ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
	  extent.attachReporter(spark);
	  ExtentTest test=extent.createTest("Verify the title");
	  
	  if(title.equals("orangehrm")) {
		  test.pass("title is match");
	  }else {
		  test.fail("test is fail");
		  File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  String dest=projectpath+"\\screenshot1.png";
		  File detfile=new File(dest);
		  FileUtils.copyFile(scr, detfile);
		  test.addScreenCaptureFromPath(dest);
	  }
	  extent.flush();
	  Thread.sleep(3000);
	  TC0012_pagefactory obj=PageFactory.initElements(driver, TC0012_pagefactory.class);

	  obj.enterusername(username);
	  obj.enterpassword(password);
	  obj.clickonlogin();
	   
		/*String title=driver.getTitle();
		//System.out.println("The Title is:"+title);
		System.out.println("Test class");
		Thread.sleep(3000);
		//WebElement username=driver.findElement(By.name("username"));
		//username.sendKeys("Admin");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();*/
	 /* System.out.println("Test class");

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      // Wait until elements are visible and interact
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(password);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
      */
  }
  
  @BeforeMethod
  public void beforeMethod() {
	    WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    System.out.println("before method"); 
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method");
	  //driver.quit();
  }
  
  @SuppressWarnings("resource")
@DataProvider
  public Object[][] dp() throws IOException {
  String[][] data=new String[3][2];
	  
	  String projectpath=System.getProperty("user.dir");
	  File file1=new File(projectpath+"\\data.xlsx");
	  FileInputStream fs=new FileInputStream(file1);
	  XSSFWorkbook workbook=new XSSFWorkbook(fs);
	  XSSFSheet worksheet=workbook.getSheetAt(0);
	  int rowcount=worksheet.getPhysicalNumberOfRows();
	  System.out.println("rows:"+rowcount);
	  
	  for(int i=0;i<rowcount;i++)
	  {
		  data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
	 
		  data[i][1]=worksheet.getRow(i).getCell(1).getStringCellValue();
	  }
	  
	  return data;
  }
  


/*  @DataProvider
  public Object[][] dp() {
	  
    return new Object[][] {
      new Object[] { "tummala", "admin123" },
      //new Object[] { "venkatesh", "Admin@123" },
     // new Object[] { "rahul", "admin123" },
    };
  }*/
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite");
  }

}
