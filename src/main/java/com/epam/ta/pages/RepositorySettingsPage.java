package com.epam.ta.pages;

import com.epam.ta.elements.Button;
import com.epam.ta.elements.Input;
import com.epam.ta.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepositorySettingsPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//button[contains(text(),'Delete this repository')]")
    private Button deleteRepoButton;

    @FindBy(id = "rename_field")
    private Input renameRepoInput;

    @FindBy(xpath = "//*[@id='options_bucket']//button[contains(text(),'Rename')]")
    private WebElement renameButton;

    public RepositorySettingsPage(WebDriver driver) {
        super(driver);
    }

    public String renameRepository(String repositoryName) {
        String repositoryFullName = repositoryName + Utils.getRandomString(6);
        renameRepoInput.write(repositoryFullName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(renameButton)).click();
        return repositoryFullName;
    }

    public void clickDeleteRepoButton() {
        deleteRepoButton.click();
    }

    @Override
    public void openPage() {

    }
}
