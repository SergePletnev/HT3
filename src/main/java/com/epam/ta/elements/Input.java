package com.epam.ta.elements;

import org.openqa.selenium.WebElement;

public class Input extends AbstractElement {
    public Input(WebElement webElement) {
        super(webElement);
    }

    public void write (String str) {
        webElement.clear();
        webElement.sendKeys(str);
    }
}
