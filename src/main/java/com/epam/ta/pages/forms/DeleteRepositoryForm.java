package com.epam.ta.pages.forms;

import com.epam.ta.elements.Button;
import com.epam.ta.elements.Input;
import com.epam.ta.elements.Label;
import com.epam.ta.elements.Link;
import com.epam.ta.pages.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DeleteRepositoryForm extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[10]/ul[1]/li[4]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/p[1]/input[1]")
    private Input verificationInput;

    @FindBy(xpath = "//p[1]/strong[2]")
    private Label repoNameLabel;

    @FindBy(xpath = "//button[contains(text(),'I understand the consequences, delete this reposit')]")
    private Button submitButton;

    public DeleteRepositoryForm(WebDriver driver) {
        super(driver);
    }

    public String getRepoName() {
        return repoNameLabel.getText();
    }

    public void fillVerificationInput(String repoName) {
        verificationInput.write(repoName);
    }

    public void submit() {
        submitButton.click();
    }

    @Override
    public void openPage() {

    }
}
