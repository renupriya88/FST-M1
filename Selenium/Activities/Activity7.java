import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println(driver.getTitle());

        WebElement element = driver.findElement(By.id("draggable") );
        WebElement element1 = driver.findElement(By.id("droppable") );
        WebElement element2 = driver.findElement(By.id("dropzone2") );

        builder.click(element).dragAndDrop(element, element1).pause(2000).release().build().perform();
        if (element1.findElement(By.tagName("p")).getText().equals("Dropped!")) {
            System.out.println("ball dropped in dropzone1");
            builder.click(element).dragAndDrop(element1, element2).pause(2000).release().build().perform();
            if (element2.findElement(By.tagName("p")).getText().equals("Dropped!")){
                System.out.println("ball dropped in dropzone2");
            }
        else {
                System.out.println("check why ball was not dropped in dropzone1");
            }
        }

        driver.quit();


    }
}
