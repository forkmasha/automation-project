package stepdefinitions;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.refresh;

import java.time.Duration;
import org.example.pages.ProductsPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsStepDefinitions {
    ProductsPage productsPage = page(ProductsPage.class);

    @When("hover over the first product")
    public void hoverOverTheFirstProduct() {
        productsPage.getFirstProduct().scrollTo().hover();
    }

    @When("click on the add to cart button")
    public void clickOnAddToCartButton() {
        productsPage.getAddToCartButton().click();
    }

    @When("click on the continue shopping button")
    public void clickOnContinueShoppingButton() {
        productsPage.getContinueShopingButton().click();
    }

    @Then("verify that the product {string} is in the cart")
    public void verifyThatTheProductIsInTheCart(String string) {
        int attempts = 0;
        while (attempts < 5) {
            try {
                productsPage.getFirstProductName(string)
                .shouldBe(Condition.visible, Duration.ofSeconds(10));
                break;
            } catch (Exception e) {
                refresh();
                attempts++;
                System.out.println("Retrying to find the product in the cart... Attempt: " + attempts);
            }
        }
    }

    @When("click on the remove button for the product {string}")
    public void clickOnTheRemoveButtonForTheProduct(String string) {
        productsPage.getRemoveButton().click();
    }

    @Then("verify that the cart is empty")
    public void verifyThatTheCartIsEmpty() {
        productsPage.getEmptyCartMessage().shouldHave(Condition.text("Cart is empty!"));
    }
}
