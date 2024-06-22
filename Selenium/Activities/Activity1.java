import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Activity1 {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
//Open a new browser to https://v1.training-support.net.
        driver.get("https://v1.training-support.net");
//Get the title of the page and print it to the console.
        System.out.println("The title of the page is " + driver.getTitle());
//Find the "About Us" button on the page using it's id.
        WebElement element = driver.findElement(By.id("about-link"));
//Click on that button.
        element.click();
//Get the title of the new page and print it to the console.
        System.out.println("The title of the NEW page is " + driver.getTitle());
//Close all selenium sessions
        driver.quit();
    }
}
