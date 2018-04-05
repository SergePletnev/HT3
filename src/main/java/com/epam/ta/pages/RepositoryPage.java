package com.epam.ta.pages;

import com.epam.ta.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RepositoryPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@data-ga-click='Empty repo, click, Clicked README link']")
    private Link addReadMeLink;

    @FindBy(xpath = "//a[@title='README.md']")
    private Link readMeLink;

    @FindBy(linkText = "Settings")
    private Link settingsLink;

    @FindBy(xpath = "//a[@data-pjax='#js-repo-pjax-container']")
    private Link currentRepositoryLink;

    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isReadMeLinkPresent() {
        return readMeLink.isPresent();
    }

    public void clickAddReadMe() {
        addReadMeLink.click();
        logger.info("RepositoryPage: Link to add README was clicked");
    }

    public void navigateToSettings() {
        settingsLink.click();
    }

    public String getCurrentRepositoryName()
    {
        return currentRepositoryLink.getText();
    }

    @Override
    public void openPage() {

    }
}
