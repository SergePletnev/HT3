package com.epam.ta.pages;

import com.epam.ta.elements.Button;
import com.epam.ta.elements.DropDown;
import com.epam.ta.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://github.com/";

	@FindBy(xpath = "//*[@id=\"your_repos\"]//a[@href='/new']")
	private Link newRepositoryLink;

	@FindBy(xpath = "//header//span[@class='dropdown-caret']")
	private DropDown setingsDropDown;

	@FindBy(xpath = "//form[@class='logout-form']//button[contains(text(),'Sign out')]")
	private Button signOutButton;

	public MainPage(WebDriver driver)
	{
		super(driver);
	}

	public void clickOnCreateNewRepositoryButton()
	{
        newRepositoryLink.click();
		logger.info("Button create 'New repository' is clicked");
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}

    public boolean isDeletedSuccessfully() {
        String pageSource = driver.getPageSource();
        return pageSource.contains("was successfully deleted");
    }

    public void logOut() {
        setingsDropDown.click();
        signOutButton.click();
    }
}
