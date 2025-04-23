package stepdefinitions;

import org.example.pages.MainPage;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;
import io.cucumber.java.en.*;

public class MainStepDefinitions {
    private MainPage mainPage = page(MainPage.class);

    @Given("open the main page")
    public void userIsOnTheMainPage() {
        open(mainPage.getMainPageUrl());

        if (mainPage.getCookiePopupCloseButton().exists()) {
            mainPage.getCookiePopupCloseButton().shouldBe(Condition.visible).click();
        } else {
            System.out.println("Cookie popup not present.");
        }
    }

    @When("click on the signup-login button")
    public void clickOnLoginButton() {
        mainPage.getSignUpLoginButton().click();
    }

    @When("click on the products button")
    public void clickOnProductsButton() {
        mainPage.getProductsButton().click();
    }

    @When("click on the delete account button")
    public void clickOnDeleteAccountButton() {
        mainPage.getDeleteAccountButton().click();
    }

    @When("click on the cart button")
    public void clickOnCartButton() {
        mainPage.getCartButton().shouldBe(Condition.clickable).click();
    }

    @Then("verify the account deletion message {string}")
    public void verifyAccountDeletionMessage(String expectedMessage) {
        String actualMessage = mainPage.getAccountDeletedTitle().getText();
        assert actualMessage.equals(expectedMessage) : "Expected message: " + expectedMessage + ", but got: " + actualMessage;
    }

    @Then("verify the user is logged in as {string}")
    public void verifyUserIsLoggedInAs(String name) {
        mainPage.getUserName().shouldHave(Condition.text(name));
    }

    @Then("click on the logout button")
    public void clickOnTheLogoutButton() {
        mainPage.getLogoutButton().click();
    }
}