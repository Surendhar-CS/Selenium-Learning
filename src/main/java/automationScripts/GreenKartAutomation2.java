package automationScripts;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class GreenKartAutomation2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String[] neededItems = { "Brocolli", "Cucumber", "Beetroot", "Carrot" };
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		int counter = 0;
		List<WebElement> Products = driver.findElements(By.className("product-name"));

		List<String> itemsList = Arrays.asList(neededItems);
		
		for (int i = 0; i < Products.size(); i++) {
			String[] name = Products.get(i).getText().split(" - ");
			System.out.println(name[0]);
			if (itemsList.contains(name[0])) {

//				driver.findElements(By.xpath("//button[contains(text(),'ADD')]")).get(i).click();
				// this might cause issue when text is dynamically changing
//			driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				counter++;
				if (counter ==neededItems.length)
					break;
			}
		}
		Thread.sleep(2000L);
		driver.quit();
	}

}
