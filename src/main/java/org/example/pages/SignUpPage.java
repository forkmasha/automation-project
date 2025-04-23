package org.example.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class SignUpPage extends BasePage {
    
    public SelenideElement getPasswordInput() {
        return getInputById("password");
    }

    public SelenideElement getFirstNameInput() {
        return getInputById("first_name");
    }

    public SelenideElement getLastNameInput() {
        return getInputById("last_name");
    }

    public SelenideElement getAddressInput() {
        return getInputById("address1");
    }

    public SelenideElement getCountrySelect() {
        return $x("//select[@id='country']");
    }

    public SelenideElement getStateInput() {
        return getInputById("state");
    }

    public SelenideElement getCityInput() {
        return getInputById("city");
    }

    public SelenideElement getZipCodeInput() {
        return getInputById("zipcode");
    }

    public SelenideElement getMobileNumberInput() {
        return getInputById("mobile_number");
    }

    public SelenideElement getCreateAccountButton() {
        return getButtonByDataQa("create-account");
    }

    public SelenideElement getAccountCreatedTitle() {
        return $x("//h2[@data-qa='account-created']/b");
    }

    public SelenideElement getContinueButton() {
        return $x("//a[@data-qa='continue-button']");
    }
}
