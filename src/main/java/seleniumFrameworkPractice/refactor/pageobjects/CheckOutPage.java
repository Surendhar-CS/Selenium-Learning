package seleniumFrameworkPractice.refactor.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkPractice.refactor.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	WebDriver driver;

	Actions key;

	@FindBy(css = ".form-group")
	WebElement countryDropdownBtn;

	@FindBy(css = ".ng-trigger-flyInOut")
	WebElement ToastError;
	
	@FindBy(css = ".action__submit")
	WebElement placeOrderBtn;
	
	@FindBy(css = ".payment__shipping .form-group button span")
	List<WebElement> countryDropdown;

	public CheckOutPage(WebDriver driver) {
		super(driver);

		this.driver = driver;
		key=new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	public void SelectCountry(String CountryName, String searchKeyword) {
		waitForElementToAppear(countryDropdownBtn);
		countryDropdownBtn.click();
		inputTextField(searchKeyword);

		waitForVisibilityOfAllElements(countryDropdown);
		WebElement Country = countryDropdown.stream().filter(country -> country.getText().equalsIgnoreCase(CountryName))
				.findFirst().orElse(null);
		key.moveToElement(Country).click().build().perform();

	}

	public OrderDetailsPage submitOrder() {
		
		placeOrderBtn.click();
		return new OrderDetailsPage(driver);
		
	}
	public String getErrorMsg()
	{
		waitForElementToAppear(ToastError);
		return ToastError.getText();
	}

}
