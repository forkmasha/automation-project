package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/resources/features/SignUpAndLogin.feature"
)
public class SignUpAndLoginTestsRunner extends BaseTestsRunner {}