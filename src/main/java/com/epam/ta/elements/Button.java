package com.epam.ta.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class Button extends BaseElement {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public String getHexColor() {
        try {
            return Color.fromString(webElement.getCssValue("background-color")).asHex();
        } catch (IllegalArgumentException e) {
            return "Element button does not have 'background-color' property";
        }

    }
}
