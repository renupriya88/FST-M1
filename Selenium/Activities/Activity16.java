import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());

        WebElement Username = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        Username.sendKeys("renu");

        WebElement Password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        Password.sendKeys("renupassword");


        WebElement ConfirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));
        ConfirmPassword.sendKeys("renupassword");


        WebElement Email = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));
        Email.sendKeys("renu@ymail.com");


        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"action-confirmation\"]")));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).isDisplayed());

        System.out.println(driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText());

        driver.quit();

    }
}
