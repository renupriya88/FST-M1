import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/input-events");

        builder.click( ).build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());

        builder.doubleClick( ).build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());

        builder.contextClick().build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());

        driver.quit();
    }
}
