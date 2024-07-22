import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @AfterClass(alwaysRun = true)
    public void closure(){
        driver.close();
    }

    @Test(alwaysRun = true)
    public void test1(){
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Target Practice");
    }

    @Test(groups = "HeaderTests")
    public void Header_Tests1(){
        WebElement third = driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        Assert.assertEquals(third.getText(), "Third header");
    }

    @Test(groups = "HeaderTests")
    public void Header_Tests2(){
        WebElement five = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        Assert.assertEquals(five.getCssValue("color"), "rgb(33, 186, 69)");
    }

    @Test(groups = "ButtonTests")
    public void Button_Tests1(){
        WebElement button = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/button[4]"));
        Assert.assertEquals(button.getText(), "Olive");

    }

    @Test(groups = "ButtonTests")
    public void Button_Tests2(){
        WebElement first = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[1]"));
        Assert.assertEquals(first.getCssValue("color"), "rgb(255, 255, 255)");

    }

}
