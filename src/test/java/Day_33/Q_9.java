package Day_33;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class Q_9 {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Launch Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void captureScreenshot() throws IOException {
        // Open Wikipedia
        driver.get("https://www.wikipedia.org/");

        // Take screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save screenshot to project folder
        String filePath = System.getProperty("user.dir") + "/homepage.png";
        FileUtils.copyFile(screenshot, new File(filePath));

        System.out.println("Screenshot saved at: " + filePath);
    }
}
