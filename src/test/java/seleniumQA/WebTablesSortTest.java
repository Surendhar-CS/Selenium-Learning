package seleniumQA;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesSortTest {

	@Test
	public static void main(String[] args) throws InterruptedException {

	}

	@Test
	public void sortedTableTest() throws InterruptedException

	{
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.cssSelector(".table-bordered thead tr th span")).click();

		// gets table elements
		List<WebElement> listItems = driver.findElements(By.cssSelector(".table-bordered td:nth-child(1)"));
		// fetches the value
		List<String> originalList = listItems.stream().map(n -> n.getText()).collect(Collectors.toList());
		// sorts it
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		// validation
		Assert.assertEquals(originalList, sortedList);
		List<String> price;

		do {
			List<WebElement> rows = driver.findElements(By.cssSelector(".table-bordered td:nth-child(1)"));
			price = rows.stream().filter(s -> s.getText().equalsIgnoreCase("Wheat")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());
			driver.findElement(By.cssSelector(".pagination [aria-label='Next']")).click();

		} while (price.size() < 1);

		
		Wait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver.findElement(By.cssSelector(".pagination [aria-label='Next']")).isEnabled());
		System.out.println(price.get(0));
		
		Thread.sleep(2000L);
		driver.quit();
	}

	public String getPriceVeggie(WebElement item) {

		// TODO Auto-generated method stub
		return item.findElement(By.xpath("following-sibling::td")).getText();
//		return item.getText();
	}

}
