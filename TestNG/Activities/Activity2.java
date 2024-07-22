import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void instance(){
        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @AfterClass
    public void close(){
        driver.close();
    }

    @Test
    public void test1(){
        Assert.assertEquals(driver.getTitle(), "Target Practice");
    }

    @Test
    public void test2(){
        WebElement black = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
        Assert.assertTrue(black.isDisplayed());
        Assert.assertNotEquals(black.getText(), "Yellow");
    }

    @Test(enabled = false)
    public void test3(){
        WebElement black = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
        System.out.println(black.getText());
        Assert.assertEquals(black.getText(), "Black");
    }

    @Test
    public void test4() {
        throw new SkipException("Skipping test case");
    }


}
