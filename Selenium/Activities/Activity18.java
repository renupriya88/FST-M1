import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity18 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println(driver.getTitle());

        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"multi-select\"]"));
        Select dropdown_list;
        dropdown_list = new Select(dropdown);

        dropdown_list.selectByVisibleText("Javascript");
        for(WebElement i : dropdown_list.getAllSelectedOptions())
        {
            System.out.println(i.getText());
        }
        System.out.println();
        System.out.println();

        dropdown_list.selectByIndex(4);
        dropdown_list.selectByIndex(5);
        dropdown_list.selectByIndex(6);
        for(WebElement j : dropdown_list.getAllSelectedOptions())
        {
            System.out.println(j.getText());
        }
        System.out.println();
        System.out.println();

        dropdown_list.selectByValue("node");
        for(WebElement l : dropdown_list.getAllSelectedOptions())
        {
            System.out.println(l.getText());
        }
        System.out.println();
        System.out.println();

        dropdown_list.deselectByIndex(5);
        for(WebElement k : dropdown_list.getAllSelectedOptions())
        {
            System.out.println(k.getText());
        }
        System.out.println();
        System.out.println();

        driver.close();


    }
}