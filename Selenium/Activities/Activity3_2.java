import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3_2 {
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();

//Open a new browser to https://v1.training-support.net/selenium/login-form
        driver.get("https://v1.training-support.net/selenium/login-form");

//Get the title of the page and print it to the console.
        System.out.println("Title of Page is " + driver.getTitle());

//Find the username field using any locator and enter "admin" into it.
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");

//Find the password field using any locator and enter "password" into it.
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");

//Find the "Log in" button using any locator and click it.
        driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();

        String a = driver.findElement(By.xpath("//div[@id ='action-confirmation']")).getText();
        System.out.println("New Page message is " + a);

        driver.quit();
    }
}
