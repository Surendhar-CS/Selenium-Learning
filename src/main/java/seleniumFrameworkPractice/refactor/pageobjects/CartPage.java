package seleniumFrameworkPractice.refactor.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkPractice.refactor.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutBtn;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean findProductInCart(String productName)
	{
		return cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
	}

	public CheckOutPage goToCheckout() {
		// TODO Auto-generated method stub
		checkOutBtn.click();
		return new CheckOutPage(driver);
	}
	
	
	
	
}
