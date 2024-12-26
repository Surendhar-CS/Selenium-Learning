package seleniumFrameworkPractice;

import static org.testng.Assert.assertEquals;

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

public class StandAloneTest {

	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://rahulshettyacademy.com/client");

		

		String product_Name = "ADIDAS ORIGINAL";

		driver.findElement(By.id("userEmail")).sendKeys("Surendhar@selenium.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sura@1234");
		driver.findElement(By.name("login")).click();

		

	

		List<WebElement> productsList = driver.findElements(By.cssSelector(".container .mb-3"));
		WebElement prod = productsList.stream().filter(product -> {
			// Extract the text from the <b> tag inside <h5> tag (product name)
			String productName = product.findElement(By.cssSelector(".card-body h5 b")).getText().trim();
			return productName.equals(product_Name); // Comparing with the desired product name
		}).findFirst().orElse(null);

		if (prod != null) {
			// Once you have the correct product, click the "Add to Cart" button
			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		} else {
			System.out.println("Product not found!");
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-animating")));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));

		

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(product_Name));
		Assert.assertTrue(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-group")));
		driver.findElement(By.cssSelector(".form-group")).click();
		
		Actions key = new Actions(driver);

		key.sendKeys("In").build().perform();

		wait.until(ExpectedConditions.visibilityOfAllElements(
				driver.findElements(By.cssSelector(".payment__shipping .form-group button span "))));
		
		List<WebElement> countryDropdown = driver
				.findElements(By.cssSelector(".payment__shipping .form-group button span "));
		
		WebElement countryS = countryDropdown.stream().filter(country -> country.getText().equalsIgnoreCase("India"))
				.findFirst().orElse(null);
		System.out.println(countryS.getAttribute("innerHTML"));
		key.moveToElement(countryS).click().build().perform();
		
//		driver.findElement(By.cssSelector(".btnn.action__submit .ng-star-inserted")).click();
//		driver.findElement(By.partialLinkText("Place Order")).click();
//		WebElement placeOrder=driver.findElement(By.partialLinkText("Place Order"));

		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		assertEquals(confirmMsg, "Thankyou for the order.");

	}

}
