import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());

        WebElement element1 = driver.findElement(By.xpath("//input[starts-with(@class, 'username-')]"));
        element1.sendKeys("admin");

        WebElement element2 = driver.findElement(By.xpath("//input[starts-with(@class, 'password-')]"));
        element2.sendKeys("password");

        driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"action-confirmation\"]")));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).isDisplayed());

        System.out.println(driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText());

        driver.quit();

    }
}
