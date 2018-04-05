package com.epam.ta.pages;

import com.epam.ta.elements.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddReadMePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "submit-file")
    private Button submitButton;

    public AddReadMePage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmitButton() {
        submitButton.click();
        logger.info("Adding README: submit button was clicked");
    }

    @Override
    public void openPage() {

    }
}
