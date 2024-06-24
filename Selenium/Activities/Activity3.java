import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();

        driver.get("http://v1.training-support.net/");

        System.out.println("Title of the webpage is " + driver.getTitle());

        WebElement element = driver.findElement(By.xpath("//a[@id='about-link']"));
        element.click();

        System.out.println("The title of the NEW page is " + driver.getTitle());
//Close all selenium sessions
        driver.quit();

    }
}
