package stepdefinitions;

import static com.codeborne.selenide.Selenide.*;
import org.example.pages.LoginPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.*;

public class LoginStepDefinitions {

    private LoginPage loginPage = page(LoginPage.class);

    @When("enter the email {string} for the login")
    public void enterTheEmailForTheLogin(String email) {
        loginPage.getEmailLoginInput().setValue(email);
    }

    @When("enter the password {string} for the login")
    public void enterPasswordForTheLogin(String string) {
        loginPage.getPasswordInput().setValue(string);
    }

    @When("click on the login button")
    public void clickOnLoginButton() {
        loginPage.getLoginButton().click();
    }

    @When("enter the name {string} and email {string} for the signup")
    public void enterTheName(String name, String email) {
        loginPage.getNameInput().setValue(name);
        loginPage.getEmailSignUpInput().setValue(email);
    }
    
    @When("click on the signup button")
    public void clickOnSignupButton() {
        loginPage.getSignupButton().click();
    } 
    
    @Then("verify the user is logged out and the login page is displayed")
    public void verifyTheUserIsLoggedOut() {
        loginPage.getLoginTitle().shouldBe(Condition.visible);
    }
}