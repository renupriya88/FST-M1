package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity_3 {
    WebDriver driver;

    @BeforeClass
    public void open(){
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/crm");

    }

    @Test
    public void copyright(){
        WebElement copyright = driver.findElement(By.id("admin_options"));
        System.out.println("The first copyright text in the footer is :" + copyright.getText());

    }

    @AfterClass
    public void close(){
        driver.close();
    }
}
