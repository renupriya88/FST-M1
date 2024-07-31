package SeleniumProject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.desktop.SystemEventListener;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class activity_7 {
    WebDriver driver;
    WebDriverWait wait;
    Actions builder;




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

    @AfterClass
    public void close(){
        driver.close();
    }

    @Test
    public void test1(){
        builder = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_0")));
        driver.findElement(By.id("grouptab_0")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"moduleTab_9_Leads\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table"))).isDisplayed();

        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".table-responsive.list > tbody > tr ")));
        List<WebElement> column = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("tr.oddListRowS1:nth-child(1) > td")));

        System.out.println("Phone number in the Additional Details pop up is as below for first record");


            String xpathExpression = "//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr[1]/td[10]";
            WebElement additionaldetailPopUpicon = driver.findElement(By.xpath(xpathExpression));
            additionaldetailPopUpicon.click();
            System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(), 'Additional Details')])[1]"))).isDisplayed());
            WebElement popupMobile = driver.findElement(By.xpath("(//div[contains(text(), 'Additional Details')])[1]"));
            Action actiontoPerform = builder.moveToElement(popupMobile).click().build();
            actiontoPerform.perform();
            System.out.println(popupMobile.getText());
            String mobile = driver.findElement(By.cssSelector("span[class='phone']")).getText();
            System.out.println(mobile);
            Assert.assertEquals(mobile,"98767890657");




    }
}
