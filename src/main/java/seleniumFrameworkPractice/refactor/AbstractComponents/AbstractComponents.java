package seleniumFrameworkPractice.refactor.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumFrameworkPractice.refactor.pageobjects.CartPage;
import seleniumFrameworkPractice.refactor.pageobjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;

	WebDriverWait wait;
	Actions key;

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartBtn;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement OrdersBtn;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		key = new Actions(driver);
	}

	public CartPage goToCartPage() {
		scrollTotheElement(cartBtn);
		waitForElementToBeClickable(cartBtn);
		cartBtn.click();
		return new CartPage(driver);
	}

	public OrderPage goToOrderPage() {
		waitForElementToBeClickable(OrdersBtn);
		OrdersBtn.click();
		return new OrderPage(driver);
	}

	public void waitForElementToBeClickable(WebElement cartBtn) {
		wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
	}

	public void waitForElementToAppear(By findBy) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToAppear(WebElement findBy) {

		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForElementToDisappear(WebElement findBy) {

		wait.until(ExpectedConditions.invisibilityOf(findBy));
	}

	public void waitForVisibilityOfAllElements(List<WebElement> countryDropdown) {

		wait.until(ExpectedConditions.visibilityOfAllElements(countryDropdown));

	}

	public void scrollTotheElement(WebElement findBy) {
		key.scrollToElement(findBy).build().perform();;
	}

	public void inputTextField(String value) {
		key.sendKeys(value).build().perform();
	}

}
