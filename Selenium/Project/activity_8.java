package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class activity_8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void start() {
        driver = new FirefoxDriver();
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
    public void close() {
        driver.close();
    }

    @Test
    public void test1() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_0")));
        driver.findElement(By.id("grouptab_0")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"moduleTab_9_Accounts\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table"))).isDisplayed();

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr"));


        System.out.println("Here are the names of the first 5 odd-numbered rows of the table Accounts.");
        int count = 5;
       for(int i = 1; i <= rows.size(); i=i+2){

            String xpathExpression = "//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr["+i+"]/td[3]";
            System.out.println(driver.findElement(By.xpath(xpathExpression)).getText());
            count = count - 1;
            if (count == 0){
                return;
            }
        }



    }
}
