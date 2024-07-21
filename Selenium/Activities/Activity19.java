import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity19 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();

        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.dismiss();

        driver.close();
    }
}
