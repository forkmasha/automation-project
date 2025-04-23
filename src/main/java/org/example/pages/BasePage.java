package org.example.pages;

import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

public class BasePage {
    protected String pageAddress = "https://www.automationexercise.com";

    public String getMainPageUrl() {
        return pageAddress;
    }

    public SelenideElement getInputByDataQa(String dataQa) {
        return $x("//input[@data-qa='" + dataQa + "']");
    }

    public SelenideElement getButtonByDataQa(String dataQa) {
        return $x("//button[@data-qa='" + dataQa + "']");
    }

    public SelenideElement getInputById(String id) {
        return $x("//input[@id='" + id + "']");
    }

    public SelenideElement getLinkByHref(String href) {
        return $x("//a[@href='" + href + "']");
    }
}
