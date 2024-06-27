import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());

        boolean x = driver.findElement(By.xpath("//*[@id=\"input-text\"]")).isEnabled();
        System.out.println(x);

        driver.findElement(By.xpath("//*[@id=\"toggleInput\"]")).click();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"input-text\"]")).isEnabled());

        driver.quit();
    }
}
