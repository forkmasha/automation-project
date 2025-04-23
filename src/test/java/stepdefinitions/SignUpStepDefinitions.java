package stepdefinitions;

import static com.codeborne.selenide.Selenide.page;

import org.example.pages.SignUpPage;

import com.codeborne.selenide.Condition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStepDefinitions {
    
    private SignUpPage signUpPage = page(SignUpPage.class);
    
    @When("enter the password {string}")
    public void enterPassword(String string) {
        signUpPage.getPasswordInput().setValue(string);
    }

    @When("enter the first name {string} and last name {string}")
    public void enterFirstAndLastName(String firstName, String lastName) {
        signUpPage.getFirstNameInput().setValue(firstName);
        signUpPage.getLastNameInput().setValue(lastName);
    }

    @When("enter the address {string}")
    public void enterAddress(String address) {
        signUpPage.getAddressInput().setValue(address);
    }

    @When("enter the country {string}, state {string} and city {string}")
    public void enterCountry(String country, String state, String city) {
        signUpPage.getCountrySelect().selectOptionContainingText(country);
        signUpPage.getStateInput().setValue(state);  
        signUpPage.getCityInput().setValue(city);
    }

    @When("enter the zip code {string}")
    public void enterZipCode(String zipCode) {
        signUpPage.getZipCodeInput().setValue(zipCode);
    }

    @When("enter the mobile number {string}")
    public void enterMobileNumber(String phoneNumber) {
        signUpPage.getMobileNumberInput().setValue(phoneNumber);
    }

    @When("click on the create account button")
    public void clickOnCreateAccountButton() {
        signUpPage.getCreateAccountButton().scrollTo().click();
    }


    @Then("verify the success message {string}")
    public void verifySuccessMessage(String message) {
        signUpPage.getAccountCreatedTitle().shouldHave(Condition.text(message));
    }

    @Then("click on the continue button")
    public void clickOnContinueButton() {
        signUpPage.getContinueButton().click();
    }
}
