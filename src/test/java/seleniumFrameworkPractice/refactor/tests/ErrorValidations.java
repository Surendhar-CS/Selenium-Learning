package seleniumFrameworkPractice.refactor.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumFrameworkPractice.refactor.TestComponents.BaseTest;
import seleniumFrameworkPractice.refactor.TestComponents.Retry;


public class ErrorValidations extends BaseTest {

	@Test(groups = {"ErrorHandlings"},retryAnalyzer =Retry.class)
	public void incorrectCredentialsTest()
	{
	landingPage.loginToAccount("Surendhar@selenium.com", "Sura@12345");
	
	Assert.assertEquals(landingPage.getErrorMsg()," Incorrect email or password");
	
	
	}
//	@Test(dataProvider = "getDatabyJson",groups = {"ErrorHandlings"})
//	public  void SubmitOrderwithoutCountry(HashMap<String,String> map) throws IOException {
//		// TODO Auto-generated method stub
//
//		
//
////		String product_Name = "ADIDAS ORIGINAL";
//
//		ProductCatalogue producOtCatalogue = landingPage.loginToAccount(map.get("username"), map.get("password"));
//		productCatalogue.addproductToCart(map.get("product_Name"));
//
//		CartPage cartPage = productCatalogue.goToCartPage();
//
//		Boolean match = cartPage.findProductInCart(map.get("product_Name"));
//		Assert.assertTrue(match);
//
//		CheckOutPage checkOutPage = cartPage.goToCheckout();
//
////		checkOutPage.SelectCountry("India", "In");
//
//		 checkOutPage.submitOrder();
//		String errorMsg = checkOutPage.getErrorMsg();
//		
//
//		SoftAssert assertion = new SoftAssert();
////		assertion.assertEquals(confirmMsg, "Thankyou for the order.");
//		assertion.assertEquals(errorMsg,"Country is blank".toUpperCase());
//
//		try {
//			assertion.assertAll();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} 
//
//	}
}
