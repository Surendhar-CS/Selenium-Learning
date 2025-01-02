package seleniumFrameworkPractice.refactor.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkPractice.refactor.AbstractComponents.AbstractComponents;

public class OrderPage  extends AbstractComponents{
	WebDriver driver;

	@FindBy(css = "table tr td:nth-child(3)")
	List<WebElement> OrdersNameList;

	

	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean findProductInOrders(String productName) {
		return OrdersNameList.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
	}
}
