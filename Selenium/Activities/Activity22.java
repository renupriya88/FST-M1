import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Activity22 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/popups");
        System.out.println(driver.getTitle());

        WebElement Sign = driver.findElement(By.className("orange"));

        builder.moveToElement(Sign).build().perform();

        System.out.println(Sign.getAttribute("data-tooltip"));

        Sign.click();

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password");

        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/button")).click();

        WebElement msg = driver.findElement(By.id("action-confirmation"));
        System.out.println(msg.getText());

        driver.close();
    }
}
