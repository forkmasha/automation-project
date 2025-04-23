package org.example.webDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HighlightingEdgeDriver extends EdgeDriver {

    private WebElement previouslyHighlightedElement;

    public HighlightingEdgeDriver(EdgeOptions options) {
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
        js.executeScript("arguments[0].style.border='5px solid red'", element);
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
