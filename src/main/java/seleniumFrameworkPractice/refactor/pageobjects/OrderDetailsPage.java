package seleniumFrameworkPractice.refactor.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkPractice.refactor.AbstractComponents.AbstractComponents;

public class OrderDetailsPage extends AbstractComponents{

	WebDriver driver;



	@FindBy(css = ".hero-primary")
	WebElement confirmMsg;

	public OrderDetailsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	

	public String getConfirmationMsg() {
		// TODO Auto-generated method stub
		return confirmMsg.getText();
	}
}
