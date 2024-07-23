import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity9 {
    WebDriver driver;


    @Test
    public void simpleAlertTestCase(){
        driver.findElement(By.xpath("//*[@id=\"simple\"]")).click();
        Reporter.log("Found simple Alert and clicked the button");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Reporter.log("Wait till alert pops up");
        Alert alert = driver.switchTo().alert();
        Reporter.log("Control switched to Alert pop up");
        String simple = alert.getText();
        Reporter.log("Getting the Alert message text into a variable simple");
        System.out.println("Simple Alert message is " + simple);
        Reporter.log("printing alert text to console");
        alert.accept();
        Assert.assertEquals(simple, "This is a JavaScript Alert!");
    }

    @Test
    public void confirmAlertTestCase(){
        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String confrm = alert.getText();
        System.out.println("Confirmation Alert Message is " + confrm);
        alert.dismiss();
        Assert.assertEquals(confrm, "This is a JavaScript Confirmation!");

    }

    @Test
    public void promptAlertTestCase(){
        driver.findElement(By.xpath("//*[@id=\"prompt\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String prompt = alert.getText();
        System.out.println("Confirmation Alert Message is " + prompt);
        alert.sendKeys("Renu");
        alert.accept();
        Assert.assertEquals(prompt, "This is a JavaScript Prompt!");

    }
    @BeforeMethod
    public void m1(){
        driver.switchTo().defaultContent();
    }
    @BeforeTest
    public void start(){
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
