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

	private static WebDriverWait wait;
	private static Actions key;



	@FindBy(css = "[routerlink*='myorders']")
	WebElement OrdersBtn;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		key = new Actions(driver);
	}

	

	public OrderPage goToOrderPage() {
		waitForElementToBeClickable(OrdersBtn);
		OrdersBtn.click();
		return new OrderPage(driver);
	}

	public static void waitForElementToBeClickable(WebElement cartBtn) {
		wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
	}

	public static void waitForElementToAppear(By findBy) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public static void waitForElementToAppear(WebElement findBy) {

		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public static void waitForElementToDisappear(WebElement findBy) {

		wait.until(ExpectedConditions.invisibilityOf(findBy));
	}

	public static void waitForVisibilityOfAllElements(List<WebElement> countryDropdown) {

		wait.until(ExpectedConditions.visibilityOfAllElements(countryDropdown));

	}

	public static void scrollTotheElement(WebElement findBy) {
		key.scrollToElement(findBy).build().perform();;
	}

	public static void inputTextField(String value) {
		key.sendKeys(value).build().perform();
	}

}
