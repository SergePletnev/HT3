package com.epam.ta.elements;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public abstract class AbstractElement {
    protected WebElement webElement;

    public AbstractElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        if (isAvailable()) {
            this.webElement.click();
        }
    }

    public boolean isPresent() {
        try
        {
            return this.webElement.isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            return false;
        }

    }

    protected boolean isAvailable() {
        return this.webElement.isEnabled();
    }

    public String getText() {
        return this.webElement.getText();
    }

    public String getAttribute(String content) {
        return webElement.getAttribute(content);
    }
}
