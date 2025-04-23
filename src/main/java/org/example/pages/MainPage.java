package org.example.pages;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class MainPage extends BasePage {

    public SelenideElement getSignUpLoginButton() {
        return getLinkByHref("/login");
    }
    
    public SelenideElement getCookiePopupCloseButton() {
        return $x("//button[@aria-label='Consent']");
    }

    public SelenideElement getDeleteAccountButton() {
        return getLinkByHref("/delete_account");
    }

    public SelenideElement getAccountDeletedTitle() {
        return $x("//h2[@data-qa='account-deleted']/b");
    }

    public SelenideElement getUserName() {
        return $x("//a[contains(text(), ' Logged in as ')]/b");
    }

    public SelenideElement getLogoutButton() {
        return getLinkByHref("/logout");
    }

    public SelenideElement getProductsButton() {
        return getLinkByHref("/products");
    }

    public SelenideElement getCartButton() {
        return getLinkByHref("/view_cart");
    }
}
