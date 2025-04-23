package org.example.pages;

import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

public class LoginPage extends BasePage 
{
    // Login to the account locators
    public SelenideElement getEmailLoginInput() {
        return getInputByDataQa("login-email");
    }

    public SelenideElement getPasswordInput() {
        return getInputByDataQa("login-password");
    }

    public SelenideElement getLoginButton() {
        return getButtonByDataQa("login-button");
    }

    //New user signup locators
    public SelenideElement getNameInput() {
        return $x("//input[@name='name']");
    }

    public SelenideElement getEmailSignUpInput() {
        return getInputByDataQa("signup-email");
    }

    public SelenideElement getSignupButton() {
        return getButtonByDataQa("signup-button");
    }

    public SelenideElement getLoginTitle() {
        return $x("//h2[contains(text(), 'Login to your account')]");
    }
}