package automationscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		 
		WebElement chkbox=driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']"));
		System.out.println(chkbox.isSelected());
		Assert.assertFalse(chkbox.isSelected());
		chkbox.click();
		System.out.println(chkbox.isSelected());
		Assert.assertTrue(chkbox.isSelected());
		Assert.assertFalse(chkbox.isSelected());
		//find the number of checkboxs
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		Thread.sleep(1000);
		
		driver.close();
	}

}
