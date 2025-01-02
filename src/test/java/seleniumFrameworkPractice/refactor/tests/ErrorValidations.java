package seleniumFrameworkPractice.refactor.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumFrameworkPractice.refactor.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test(groups = {"ErrorHandlings"})
	public void incorrectCredentialsTest()
	{
	landingPage.loginToAccount("Surendhar@selenium.com", "Sura@12345");
	
	Assert.assertEquals(landingPage.getErrorMsg()," Incorrect email or password");
	
	
	}
	
}
