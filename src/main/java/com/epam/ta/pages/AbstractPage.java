package com.epam.ta.pages;

import com.epam.ta.decorator.CustomFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage
{
	protected WebDriver driver;

	public abstract void openPage();

	public AbstractPage(WebDriver driver)
	{
		this.driver = driver;
		//using decorator to create custom elements
		PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
	}
}
