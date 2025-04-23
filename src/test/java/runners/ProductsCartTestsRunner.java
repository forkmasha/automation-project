package runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.collect.ImmutableMap;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.webDriverFactory.CustomWebDriverProvider;
import org.example.webDriverFactory.WebDriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@CucumberOptions(
        glue = "stepdefinitions",
        features = "src/test/java/resources/features/ProductsCart.feature",
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
)
public class ProductsCartTestsRunner extends AbstractTestNGCucumberTests {
    static {
        Configuration.browser = CustomWebDriverProvider.class.getName();
    }

    @BeforeSuite
    public void addAllure(){
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true));
    }
    @Before()
    public void setUp() {
        WebDriverFactory.getDriver();
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Selenide.screenshot("error_screenshot");
        }
        WebDriverFactory.closeBrowser();
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return screenshot(OutputType.BYTES);
    }
}