package com.epam.ta.pages;

import com.epam.ta.elements.Button;
import com.epam.ta.elements.Input;
import com.epam.ta.elements.Label;
import com.epam.ta.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.epam.ta.utils.Utils;

public class CreateNewRepositoryPage extends AbstractPage
{
	private final String BASE_URL = "http://www.github.com/new";
	private final Logger logger = LogManager.getRootLogger();

	@FindBy(id = "repository_name")
	private Input repositoryNameInput;

	@FindBy(id = "repository_description")
	private Input repositoryDescriptionInput;

	@FindBy(xpath = "//form[@id='new_repository']//button[@type='submit']")
	private Button createButton;

	@FindBy(xpath = "//div[@class='Box-header Box-header--blue']//*[contains(text(),'Quick setup')]")
	private Label emptyRepoSetupLabel;

	@FindBy(xpath = "//a[@data-pjax='#js-repo-pjax-container']")
	private Link currentRepositoryLink;

	public CreateNewRepositoryPage(WebDriver driver)
	{
		super(driver);
	}

	public boolean isCurrentRepositoryEmpty()
	{
		return emptyRepoSetupLabel.isPresent();
	}

	public String createNewRepository(String repositoryName, String repositoryDescription)
	{
		String repositoryFullName = repositoryName + Utils.getRandomString(6);
		repositoryNameInput.write(repositoryFullName);
		repositoryDescriptionInput.write(repositoryDescription);
		createButton.click();
		return repositoryFullName;
	}

	public String getCurrentRepositoryName()
	{
		return currentRepositoryLink.getText();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}

}
