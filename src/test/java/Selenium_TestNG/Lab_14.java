package Selenium_TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab_14 {

    WebDriver driver;
    String propath = System.getProperty("user.dir");

    @Test(dataProvider = "dp")
    public void f(String firstname, String lastname, String email, String telephone, String password, String con_password) throws InterruptedException {
        // click on my account
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        // click on Register
        driver.findElement(By.linkText("Register")).click();

        Thread.sleep(2000);
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

        // verify success
        Thread.sleep(2000);
        WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        String SuccessText = successMsg.getText();
        if (SuccessText.contains("Your Account Has Been Created!")) {
            System.out.println("✅ Account created successfully!");
        } else {
            System.out.println("❌ Registration failed!");
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?");
    }

    @AfterMethod
    public void afterMethod() {
       // driver.quit();
    }

    @DataProvider
    public Object[][] dp() throws IOException {
        File file2 = new File(propath + "\\UserDetails.xlsx");
        FileInputStream fs = new FileInputStream(file2);
        XSSFWorkbook workbook1 = new XSSFWorkbook(fs);
        XSSFSheet worksheet1 = workbook1.getSheetAt(0);

        int rowcount = worksheet1.getPhysicalNumberOfRows();
        int colcount = worksheet1.getRow(0).getLastCellNum();

        System.out.println("Rows: " + rowcount + " | Cols: " + colcount);

        DataFormatter formatter = new DataFormatter();

        // Count only non-empty rows
        int validRows = 0;
        for (int i = 1; i < rowcount; i++) {
            if (worksheet1.getRow(i) != null &&
                worksheet1.getRow(i).getCell(0) != null &&
                !formatter.formatCellValue(worksheet1.getRow(i).getCell(0)).trim().isEmpty()) {
                validRows++;
            }
        }

        Object[][] data = new Object[validRows][colcount];

        int index = 0;
        for (int i = 1; i < rowcount; i++) { // start at 1 → skip header
            if (worksheet1.getRow(i) != null &&
                worksheet1.getRow(i).getCell(0) != null &&
                !formatter.formatCellValue(worksheet1.getRow(i).getCell(0)).trim().isEmpty()) {

                for (int j = 0; j < colcount; j++) {
                    data[index][j] = formatter.formatCellValue(worksheet1.getRow(i).getCell(j));
                }
                index++;
            }
        }

        workbook1.close();
        return data;
    }

}
