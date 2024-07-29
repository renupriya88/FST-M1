package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity_2 {
    WebDriver driver;

    @BeforeClass
    public void open(){
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/crm");

    }

    @Test
    public void header(){
        WebElement header_url = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form[1]/div[1]/img"));
        System.out.println("URL of the header image is :" + header_url.getAttribute("src"));

    }

    @AfterClass
    public void close(){
        driver.close();
    }

}
