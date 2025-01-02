package seleniumFrameworkPractice.refactor.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import seleniumFrameworkPractice.refactor.TestComponents.BaseTest;
import seleniumFrameworkPractice.refactor.pageobjects.CartPage;
import seleniumFrameworkPractice.refactor.pageobjects.CheckOutPage;
import seleniumFrameworkPractice.refactor.pageobjects.LandingPage;
import seleniumFrameworkPractice.refactor.pageobjects.OrderDetailsPage;
import seleniumFrameworkPractice.refactor.pageobjects.OrderPage;
import seleniumFrameworkPractice.refactor.pageobjects.ProductCatalogue;

public class PlaceOrderTest extends BaseTest {

	

	@Test
	public  void SubmitOrderTest() throws IOException {
		// TODO Auto-generated method stub

		

		String product_Name = "ADIDAS ORIGINAL";

		ProductCatalogue productCatalogue = landingPage.loginToAccount("Surendhar@selenium.com", "Sura@1234");
		productCatalogue.addproductToCart(product_Name);

		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.findProductInCart(product_Name);
		Assert.assertTrue(match);

		CheckOutPage checkOutPage = cartPage.goToCheckout();

		checkOutPage.SelectCountry("India", "In");

		OrderDetailsPage OrderDetails = checkOutPage.submitOrder();
		String confirmMsg = OrderDetails.getConfirmationMsg();
		

		SoftAssert assertion = new SoftAssert();
//		assertion.assertEquals(confirmMsg, "Thankyou for the order.");
		assertion.assertEquals(confirmMsg,"Thankyou for the order.".toUpperCase());

		try {
			assertion.assertAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 

	}
	@Test(dependsOnMethods = {"SubmitOrderTest"})
	public void OrderpageProductValidation() {
		String product_Name = "ADIDAS ORIGINAL";
		ProductCatalogue productCatalogue = landingPage.loginToAccount("Surendhar@selenium.com", "Sura@1234");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		
		Assert.assertTrue(orderPage.findProductInOrders(product_Name));
	}
}