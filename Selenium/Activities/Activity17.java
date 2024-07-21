import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println(driver.getTitle());

        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"single-select\"]"));
        Select dropdown_list;
        dropdown_list = new Select(dropdown);

        dropdown_list.selectByVisibleText("Option 2");
        System.out.println(dropdown_list.getFirstSelectedOption().getText());

        dropdown_list.selectByIndex(3);
        System.out.println(dropdown_list.getFirstSelectedOption().getText());

        dropdown_list.selectByValue("4");
        System.out.println(dropdown_list.getFirstSelectedOption().getText());

        List<WebElement> allOptions = dropdown_list.getOptions();
        for(WebElement i : allOptions){
            System.out.println(i.getText());

        }
        driver.close();
    }
}
