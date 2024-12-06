package AutomationScripts;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartAutomation3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		// Explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		String[] neededItems = { "Brocolli", "Cucumber", "Beetroot", "Carrot" };
		addItemsToCart(driver, neededItems);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();

		// explicit wait for Coupon text box
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));

		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();

		// explicit wait for coupon success msg
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		Thread.sleep(2000L);
		driver.quit();
	}

	public static void addItemsToCart(WebDriver driver, String[] neededItems) {
		int counter = 0;
		List<WebElement> Products = driver.findElements(By.className("product-name"));

		List<String> itemsList = Arrays.asList(neededItems);

		for (int i = 0; i < Products.size(); i++) {
			String[] name = Products.get(i).getText().split(" - ");
			System.out.println(name[0]);
			if (itemsList.contains(name[0])) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				counter++;
				if (counter == neededItems.length)
					break;
			}
		}
	}

}
