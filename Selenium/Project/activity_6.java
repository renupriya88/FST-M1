package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity_6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void open(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("http://alchemy.hguy.co/crm");
        WebElement username = driver.findElement(By.id("user_name"));
        WebElement password = driver.findElement(By.id("username_password"));
        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        driver.manage().window().maximize();

    }

    @Test
    public void Menu_checking(){
        String name = driver.findElement(By.id("grouptab_3")).getText();
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_3"))));
        System.out.println(wait.until(ExpectedConditions.elementToBeClickable(By.id("grouptab_3"))));
        Assert.assertEquals(name, "ACTIVITIES");

    }

    @AfterClass
    public void close(){
        driver.close();
    }
}
