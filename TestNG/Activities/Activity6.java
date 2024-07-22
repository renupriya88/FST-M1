import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @AfterClass
    public void close(){
        driver.close();
    }
    @Test
    @Parameters({"username", "password"})
    public void test1(String username, String password) {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText());
    }

}
