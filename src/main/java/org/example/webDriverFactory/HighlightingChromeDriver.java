package org.example.webDriverFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HighlightingChromeDriver extends ChromeDriver {

    private WebElement previouslyHighlightedElement;

    public HighlightingChromeDriver(ChromeOptions options) {
        super(options);
    }

    @Override
    public WebElement findElement(By by) {
        WebElement element = super.findElement(by);
        unhighlightPreviousElement();
        highlightElement(element);
        previouslyHighlightedElement = element;
        return element;
    }

    @Override
    public void get(String url) {
        super.get(url);
    }

    private void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) this;
        js.executeScript("arguments[0].style.border='3px solid green'", element);
    }

    private void unhighlightElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) this;
            js.executeScript("arguments[0].style.border=''", element);
        }
        catch (Exception e) { }
    }

    private void unhighlightPreviousElement() {
        if (previouslyHighlightedElement != null) {
            unhighlightElement(previouslyHighlightedElement);
        }
    }
}