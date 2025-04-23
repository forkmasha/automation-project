package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/resources/features/ProductsCart.feature"
)
public class ProductsCartTestsRunner extends BaseTestsRunner {}