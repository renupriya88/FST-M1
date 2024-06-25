import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(1000));

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Page Title is " + driver.getTitle());

        WebElement toggleCheckbox = driver.findElement(By.id("toggleCheckbox"));
        WebElement dynamicBox = driver.findElement(By.id("dynamicCheckbox"));

        toggleCheckbox.click();
        wait.until(ExpectedConditions.invisibilityOf(dynamicBox));
        System.out.println("Dynamic check box is not visible " + dynamicBox.getText());

        toggleCheckbox.click();
        wait.until(ExpectedConditions.visibilityOf(dynamicBox));
        System.out.println(dynamicBox.getText());

        dynamicBox.click();

        driver.quit();
    }
}
