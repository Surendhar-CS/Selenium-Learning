package seleniumFrameworkPractice.refactor.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkPractice.refactor.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".container .mb-3")
	List<WebElement> productsList;

	@FindBy(css =".ng-animating")
	WebElement loadingAnimation;
	
	By ProductNamefield = By.cssSelector(".card-body h5 b");

	By AddToCartBtn = By.cssSelector(".card-body button:last-of-type");
	By toastMsg=By.cssSelector("#toast-container");
	By loadingAnimationBy=By.cssSelector(".ng-animating");
	
	


	public void addproductToCart(String prodName) {
		WebElement prod = findProduct(prodName);
		prod.findElement(AddToCartBtn).click();
		
		waitForElementToAppear(toastMsg);
		waitForElementToAppear(loadingAnimationBy);
		waitForElementToDisappear(loadingAnimation);
	}

	public WebElement findProduct(String prodName) {

		return productsList.stream().filter(product -> {
			// Extract the text from the <b> tag inside <h5> tag (product name)
			String productName = product.findElement(ProductNamefield).getText().trim();
			return productName.equals(prodName); // Comparing with the desired product name
		}).findFirst().orElse(null);

	}

}
