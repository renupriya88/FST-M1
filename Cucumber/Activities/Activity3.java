package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3 {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void User_is_on_the_page(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void User_clicks_the_Simple_Alert_button(){
        driver.findElement(By.id("simple")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void User_clicks_the_Confirm_Alert_button(){
        driver.findElement(By.id("confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void User_clicks_the_Prompt_Alert_button(){
        driver.findElement(By.id("prompt")).click();
    }

    @Then("^Alert opens$")
    public void Alert_opens(){
        alert = driver.switchTo().alert();

    }

    @And("^Read the text from it and print it$")
    public void Read_the_text_from_it_and_print_it(){
        System.out.println(alert.getText());
    }

    @And("^Close the alert$")
    public void Close_the_alert(){
        alert.accept();
    }

    @And("^Close Browser$")
    public void Close_Browser(){
        driver.close();
    }

    @And("^Close the alert with Cancel$")
    public void Close_the_alert_with_Cancel(){
        alert.dismiss();
    }

    @And("^Write a custom message in it$")
    public void Write_a_custom_message_in_it(){
        alert.sendKeys("RenupriyaNair");
    }



}
