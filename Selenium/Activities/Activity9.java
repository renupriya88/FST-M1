import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println(driver.getTitle());

        WebElement changecontent = driver.findElement(By.cssSelector("button.violet"));
        changecontent.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"),"I'm late!"));
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.quit();
    }
}
