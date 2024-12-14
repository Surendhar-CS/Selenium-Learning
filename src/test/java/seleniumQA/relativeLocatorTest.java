package seleniumQA;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class relativeLocatorTest {

	WebDriver driver = new EdgeDriver();

	@BeforeTest
	public void LaunchBrowser() {

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
	}

	@Test(enabled = false)
	public void relativeLocatorTest_TC01() {
		WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
		By nameLabel = RelativeLocator.with(By.tagName("label")).above(nameField);
		
		WebElement dobBox= driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(dobBox)).click();
		System.out.println(driver.findElement(nameLabel).getText());
		WebElement checkBox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(checkBox)).click();
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		WebElement radioLabel = driver.findElement(RelativeLocator.with(By.tagName("label")).toRightOf(nameLabel));
		System.out.println(radioLabel.getText());

	}
	@Test
	public void invokingMultipleWindowsTest() {
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
		String parentID = itr.next();
		String childID = itr.next();
		driver.get("https://rahulshettyacademy.com");
		driver.switchTo().window(childID);

		String firstCourse = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		driver.switchTo().window(parentID);
		WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
		nameField.sendKeys(firstCourse);
		
		}

	@AfterTest
	public void closeDriver() throws InterruptedException {
		Thread.sleep(4000L);
		driver.quit();
	}
}
