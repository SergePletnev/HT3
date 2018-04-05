package com.epam.ta.pages;

import com.epam.ta.elements.Button;
import com.epam.ta.elements.Input;
import com.epam.ta.elements.Link;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://github.com/login";

	@FindBy(id = "login_field")
	private Input loginInput;

	@FindBy(id = "password")
	private Input passwordInput;

	@FindBy(xpath = "//input[@value='Sign in']")
	private Button submitButton;

	@FindBy(xpath = "//meta[@name='user-login']")
	private Link loggedInUserLink;

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password)
	{
		loginInput.write(username);
		passwordInput.write(password);
		submitButton.click();
		logger.info("Login performed");
	}

	public String getLoggedInUserName()
	{
		return loggedInUserLink.getAttribute("content");
	}

}
