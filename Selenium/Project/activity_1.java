package SeleniumProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity_1 {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    String website_Title;

    @BeforeClass
    public void open(){
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/crm");
        website_Title = driver.getTitle();
    }

    @Test(dependsOnMethods = {"verifyTitle"})
    public void close(){
        System.out.println("Title of the website is : " + website_Title);
        driver.quit();
    }

    @Test
    public void verifyTitle(){
        Assert.assertEquals(website_Title, "SuiteCRM");
    }
}
