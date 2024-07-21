import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity20 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//*[@id=\"prompt\"]")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.sendKeys("Awesome!");

        alert.accept();


        driver.close();
    }
}
