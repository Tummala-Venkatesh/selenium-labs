package Day_33;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q_7 {
    WebDriver driver;

    @Test
    public void fetchTableData() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        System.out.println("Table 1");

        for (WebElement row : rows) {
            String lastName = row.findElement(By.xpath("./td[1]")).getText();
            String firstName = row.findElement(By.xpath("./td[2]")).getText();
            String email = row.findElement(By.xpath("./td[3]")).getText();

    
            System.out.println(firstName + " " + lastName);

         
            if (firstName.equalsIgnoreCase("Jason")) {
                System.out.println("👉 Email of Jason: " + email);
            }
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
