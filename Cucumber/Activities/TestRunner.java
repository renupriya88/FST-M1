import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = {"stepdefinitions"},
        tags = "@SmokeTest",
        plugin = {"pretty"},
        monochrome = true
)

public class TestRunner {}