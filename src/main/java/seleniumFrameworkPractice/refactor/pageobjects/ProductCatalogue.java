package seleniumFrameworkPractice.refactor.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkPractice.refactor.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	Actions actions;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".container .mb-3")
	List<WebElement> productsList;

	@FindBy(css =".ng-animating")
	WebElement loadingAnimation;
	
	@FindBy(css =".card-body button:last-of-type")
	WebElement AddToCartBtnElement;
	
	By ProductNamefield = By.cssSelector(".card-body h5 b");

	By AddToCartBtn = By.cssSelector(".card-body button:last-of-type");
	
	By toastMsg=By.cssSelector("#toast-container");
	By loadingAnimationBy=By.cssSelector(".ng-animating");
	
	


	public void addproductToCart(String prodName) {
		actions=new Actions(driver);
		WebElement prod = findProduct(prodName);
//		waitForElementToBeClickable(AddToCartBtn);
		scrollTotheElement(prod.findElement(AddToCartBtn));
		prod.findElement(AddToCartBtn).click();
	
		waitForElementToAppear(toastMsg);
		waitForElementToAppear(loadingAnimationBy);
		waitForElementToDisappear(loadingAnimation);
	}

	public WebElement findProduct(String prodName) {

		waitForVisibilityOfAllElements(productsList);
		return productsList.stream().filter(product -> {
			// Extract the text from the <b> tag inside <h5> tag (product name)
			String productName = product.findElement(ProductNamefield).getText().trim();
			System.out.println(productName);
			return productName.equals(prodName); // Comparing with the desired product name
		}).findFirst().orElse(null);

	}

}
