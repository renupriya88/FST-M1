import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;

public class Activity4 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");

        System.out.println("Title of the page is " + driver.getTitle());

        WebElement element = driver.findElement(By.xpath("//h3[@id='third-header']"));

        System.out.println("3rd header on the page text is " + element.getText());

        WebElement element1 = driver.findElement(By.xpath("//h5[@class='ui green header']"));

        System.out.println(element1.getCssValue("color"));

        System.out.println(driver.findElement(By.xpath("//button[text() = 'Violet']")).getAttribute("class"));

        System.out.println(driver.findElement(By.xpath("//button[text() = 'Grey']")).getText());

        driver.quit();


    }
}
