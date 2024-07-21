import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity21 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium/tab-opener");
        String title = driver.getTitle();
        String parentHandle = driver.getWindowHandle();
        System.out.println("1st window title is " + title);
        System.out.println(parentHandle);

        driver.findElement(By.id("launcher")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        System.out.println("Name of handles are below : " + driver.getWindowHandles());

        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        System.out.println("2nd Window Title is " + driver.getTitle());
        System.out.println(driver.findElement(By.className("content")).getText());

        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        wait.until(ExpectedConditions.titleIs("Newtab2"));
        System.out.println("3rd Window Title is " + driver.getTitle());
        System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div")).getText());

        driver.quit();

    }
}
