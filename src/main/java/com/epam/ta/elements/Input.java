package com.epam.ta.elements;

import org.openqa.selenium.WebElement;

public class Input extends BaseElement {
    public Input(WebElement webElement) {
        super(webElement);
    }

    public void fill(String str) {
        webElement.clear();
        webElement.sendKeys(str);
    }
}
