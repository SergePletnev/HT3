package com.epam.ta.steps;

import com.epam.ta.driver.WebDriverSingleton;
import com.epam.ta.pages.*;
import com.epam.ta.pages.forms.DeleteRepositoryForm;
import com.epam.ta.utils.BrowserManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = WebDriverSingleton.getDriver();
		BrowserManager browserManager = new BrowserManager(driver);
		browserManager.setTimeOuts();
		browserManager.maximize();
	}

	public void closeDriver()
	{
		WebDriverSingleton.closeDriver();
	}

	public void loginGithub(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		logger.info("Actual username: " + actualUsername);
		return actualUsername.equals(username);
	}

	public boolean createNewRepository(String repositoryName, String repositoryDescription)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
		return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}

    public boolean addReadMe() {
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.clickAddReadMe();
        AddReadMePage addReadMePage = new AddReadMePage(driver);
        addReadMePage.clickSubmitButton();
        return repositoryPage.isReadMeLinkPresent();
    }

    public void logOut() {
        MainPage mainPage = new MainPage(driver);
        mainPage.logOut();
    }

    public boolean deleteCreatedRepository() {
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.navigateToSettings();
        RepositorySettingsPage repositorySettingsPage = new RepositorySettingsPage(driver);
        repositorySettingsPage.clickDeleteRepoButton();
        DeleteRepositoryForm deleteRepositoryForm = new DeleteRepositoryForm(driver);
        deleteRepositoryForm.fillVerificationInput(deleteRepositoryForm.getRepoName());
        deleteRepositoryForm.submit();
        MainPage mainPage = new MainPage(driver);
        return mainPage.isDeletedSuccessfully();
    }

    public boolean renameRepository(String newRepoNamesitory) {
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.navigateToSettings();
        RepositorySettingsPage repositorySettingsPage = new RepositorySettingsPage(driver);
        String expectedName = repositorySettingsPage.renameRepository(newRepoNamesitory);
        return expectedName.equals(repositoryPage.getCurrentRepositoryName());
    }
}
