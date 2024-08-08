package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity4 {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on the Login page$")
    public void User_is_on_Login_page(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium/login-form");
    }
/*
    @When("^User enters username and password$")
    public void enter_credential(){
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("admin");
        password.sendKeys("password");

        driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
    }
*/
    @When("^User enters {string} and {string}$")
    public void User_enters_username_and_password(String username, String password){
        WebElement username1 = driver.findElement(By.id("username"));
        WebElement password1 = driver.findElement(By.id("password"));

        username1.sendKeys(username);
        password1.sendKeys(password);

        driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
    }

    @Then("^Read the pages title and confirmation message$")
    public void Read_the_page_title_and_confirmation_message(){
        System.out.println("Page Title is " + driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText());
    }

    @And("^Quit the Browser$")
    public void Close_the_Browser(){
        driver.close();
    }
}
