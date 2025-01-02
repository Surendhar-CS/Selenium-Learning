package seleniumFrameworkPractice.refactor.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkPractice.refactor.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	
	WebDriver driver;
	
	@FindBy(id="userEmail")
	WebElement emailField;
	
	@FindBy(id="userPassword")
	WebElement passwordField;
	
	@FindBy(name="login")
	WebElement loginBtn;
	
	@FindBy(css=".ng-trigger-flyInOut")
	WebElement toastMsgError;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public ProductCatalogue loginToAccount(String username,String password)
	{
		emailField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
		return new ProductCatalogue(driver);
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMsg()
	{
		return toastMsgError.getText();
	}
}
