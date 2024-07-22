import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity7 {
    WebDriver driver;

    @BeforeClass
    public void set(){
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials()
    {
            return new Object[][] {{"admin", "password"}};
    }

    @Test(dataProvider = "Authentication")
    public void test1(String username, String password){
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
        String msg = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText();
        String expected = "Welcome Back, admin";
        Assert.assertEquals(msg, expected);

    }


    @AfterClass
    public void close(){
        driver.close();
    }
}
