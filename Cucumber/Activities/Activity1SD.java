package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1SD {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^user is on the google website$")
    public void user_is_on_the_google_website(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://duckduckgo.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a/img")));

    }

    @When("^user types cheese and hits enter$")
    public void user_types_cheese_and_hits_enter(){
        driver.findElement(By.id("searchbox_input")).sendKeys("Cheese", Keys.RETURN);

    }

    @Then("^we should see the number of results$")
    public void we_should_see_the_number_of_results(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[6]/div[4]/div/div/div/div/section[1]/ol/li[1]/div/div/div/section/div/a[2]")));
        System.out.println("element detected");

    }

    @And("^close the browser$")
    public void close_the_browser(){
        driver.quit();
    }
}
