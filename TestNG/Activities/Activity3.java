import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void pre(){
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Title of the page is " + driver.getTitle());

    }

    @Test
    public void test1(){
        WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        username.sendKeys("admin");
        password.sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
        String msg = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText();
        Assert.assertEquals(msg, "Welcome Back, admin");
    }

    @Test
    public void test2(){
        WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        username.sendKeys("roy");
        password.sendKeys("animal");
        driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
        String msg = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText();
        Assert.assertEquals(msg, "Welcome Back, admin");
    }

    @AfterClass
    public void last(){
        driver.close();
    }

}
