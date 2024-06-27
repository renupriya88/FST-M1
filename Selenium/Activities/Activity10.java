import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity10 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());

        System.out.println(driver.findElement(By.xpath("//*[@id=\"dynamicCheckbox\"]/input")).isDisplayed());

        driver.findElement(By.xpath("//*[@id=\"toggleCheckbox\"]")).click();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"dynamicCheckbox\"]/input")).isDisplayed());

        driver.quit();



    }
}
