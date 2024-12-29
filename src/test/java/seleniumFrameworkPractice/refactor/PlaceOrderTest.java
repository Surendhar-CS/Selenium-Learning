package seleniumFrameworkPractice.refactor;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import seleniumFrameworkPractice.refactor.pageobjects.CartPage;
import seleniumFrameworkPractice.refactor.pageobjects.CheckOutPage;
import seleniumFrameworkPractice.refactor.pageobjects.LandingPage;
import seleniumFrameworkPractice.refactor.pageobjects.OrderDetailsPage;
import seleniumFrameworkPractice.refactor.pageobjects.ProductCatalogue;

public class PlaceOrderTest {

	

	@Test
	public static void SubmitOrderTest() {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String product_Name = "ADIDAS ORIGINAL";

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();

		ProductCatalogue productCatalogue = landingPage.loginToAccount("Surendhar@selenium.com", "Sura@1234");
		productCatalogue.addproductToCart(product_Name);

		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.findProductInCart(product_Name);
		Assert.assertTrue(match);

		CheckOutPage checkOutPage = cartPage.goToCheckout();

		checkOutPage.SelectCountry("India", "In");

		OrderDetailsPage OrderDetails = checkOutPage.submitOrder();
		String confirmMsg = OrderDetails.getConfirmationMsg();
		driver.findElement(By.cssSelector(".hero-primary")).getText();

		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(confirmMsg, "Thankyou for the order.");

		try {
			assertion.assertAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.quit();
		}

	}
}
