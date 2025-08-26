package Day_33;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q_8 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void multipleWindowsHandling() {
 
        driver.findElement(By.linkText("Click Here")).click();

       
        String pWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

     
        for (String h : allWindows) {
            if (!h.equals(pWindow)) {
                driver.switchTo().window(h);
            }
        }

        driver.switchTo().window(pWindow);
        System.out.println(driver.getTitle());
    }
}
