import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());

        boolean x = driver.findElement(By.xpath("//*[@id=\"dynamicCheckbox\"]/input")).isSelected();
        System.out.println(x);

        driver.findElement(By.xpath("//*[@id=\"dynamicCheckbox\"]/input")).click();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"dynamicCheckbox\"]/input")).isSelected());

        driver.quit();



    }
}
