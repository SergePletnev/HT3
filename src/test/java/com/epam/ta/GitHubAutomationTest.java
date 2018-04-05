package com.epam.ta;

import com.epam.ta.config.Config;
import org.testng.Assert;
import org.testng.annotations.*;

import com.epam.ta.steps.Steps;

public class GitHubAutomationTest
{
	private Steps steps;
	private final String USERNAME = "testautomationuser";
	private final String PASSWORD = "Time4Death!";

	@BeforeClass (description = "Loading config")
	public void setupClass() throws Exception {
		Config.loadConfig();
        steps = new Steps();
        steps.initBrowser();
	}

	@BeforeMethod (description = "Login to Github")
	public void setUpMethod()	{
        steps.loginGithub(USERNAME, PASSWORD);
	}



    @Test (description = "Correct name after authorization")
    public void tstCorrectName()
    {
        Assert.assertTrue(steps.isLoggedIn(USERNAME), "[Username is not the same as username when login]");
    }

	@Test (description = "Create new repository")
	public void oneCanCreateRepository()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"),
                "Actual name of created repository is not as expected name");
		Assert.assertTrue(steps.currentRepositoryIsEmpty(), "[Created repository is not empty]");
	}

    @Test (description = "Add README")
    public void oneCanAddReadMe()
    {
        steps.createNewRepository("testRepo", "auto-generated test repo");
        Assert.assertTrue(steps.addReadMe(), "README could not be found after adding");
    }

    @Test (description = "Rename repository")
    public void oneCanRenameRepository()
    {
        steps.createNewRepository("testRepo", "auto-generated test repo");
        Assert.assertTrue(steps.renameRepository("RenamedRepo"), "[Repository was not renamed correctly]");
    }

    @Test (description = "Delete created repository")
    public void oneCanDeleteCreatedRepo() {
        steps.createNewRepository("testRepo", "auto-generated test repo");
        Assert.assertTrue(steps.deleteCreatedRepository(), "[Repository deletion was failed]");
    }



    @AfterMethod (description = "Log out GitHub")
    public void teardownMethod() {
        steps.logOut();
    }

    @AfterClass(description = "Stop Browser")
    public void tearDownClass() {
        steps.closeDriver();
    }

}
