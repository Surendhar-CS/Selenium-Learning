package seleniumFrameworkPractice.refactor.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkPractice.refactor.AbstractComponents.AbstractComponents;

public class HomePage {
	
  WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*='cart']")
	 WebElement cartBtn;
	
	
	public  CartPage goToCartPage() {
		AbstractComponents.scrollTotheElement(cartBtn);
		System.out.println(driver.getCurrentUrl());
		AbstractComponents.waitForElementToBeClickable(cartBtn);
		
		cartBtn.click();
		return new CartPage(driver);
	}
}
