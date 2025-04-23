package org.example.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

public class ProductsPage extends BasePage {
    public SelenideElement getFirstProduct() {
        return $x("//div[@class='single-products'][1]");
    }

    public SelenideElement getAddToCartButton() {
        return $("a[data-product-id='1']", 1);
    }

    public SelenideElement getContinueShopingButton() {
        return $x("//button[contains(text(), 'Continue Shopping')]");
    }

    public SelenideElement getFirstProductName(String productName) {
        return $x("//a[contains(text(), '"+ productName + "')]");
    }

    public SelenideElement getRemoveButton() {
        return $x("//a[@class='cart_quantity_delete']");
    }

    public SelenideElement getEmptyCartMessage() {
        return $x("//span[@id='empty_cart']/p");
    }
}
