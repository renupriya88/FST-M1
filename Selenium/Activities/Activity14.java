import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println(driver.getTitle());

        List<WebElement> rows = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr"));
        System.out.println("Num of rows is : " + rows.size());

        List<WebElement> columns = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td"));
        System.out.println("Num of rows is : " + columns.size());


        WebElement second_row_column = driver.findElement(By.xpath("//*[@id=\"sortableTable\"]/tbody/tr[2]/td[2]"));
        System.out.println(second_row_column.getText());

        WebElement y = driver.findElement(By.xpath("//*[@id=\"sortableTable\"]/thead/tr/th[1]"));
        System.out.println(y.getText());
        y.click();

        WebElement second_row_column1 = driver.findElement(By.xpath("//*[@id=\"sortableTable\"]/tbody/tr[2]/td[2]"));
        System.out.println(second_row_column1.getText());

        List<WebElement> footer = driver.findElements(By.xpath("//*[@id=\"sortableTable\"]/tfoot/tr/th"));
        for (WebElement x : footer){
            System.out.println(x.getText());
        }

        driver.quit();
    }
}
