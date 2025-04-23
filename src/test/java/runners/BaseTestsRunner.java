package runners;

import org.example.webDriverFactory.CustomWebDriverProvider;
import org.example.webDriverFactory.WebDriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.codeborne.selenide.Configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    glue = "stepdefinitions",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber-reports.json"
    },
    monochrome = true
)
public class BaseTestsRunner extends AbstractTestNGCucumberTests {
    @Before()
    public void setUp() {
        WebDriverFactory.getDriver();
        Configuration.browser = CustomWebDriverProvider.class.getName();
    }

    @After()
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        WebDriverFactory.closeBrowser();
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
