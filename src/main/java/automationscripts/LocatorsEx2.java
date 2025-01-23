package automationscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

class LocatorsEx2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SURA\\Documents\\Selenium QA\\seleniumQA\\src\\main\\resources\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("suratest");
		driver.findElement(By.cssSelector(".form input:nth-child(3)")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//label[@for='chkboxOne']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
//		String msg=driver.findElement(By.tagName("p")).getText();
		String msg=driver.findElement(By.cssSelector("#root p")).getText();
		Assert.assertEquals(msg, "You are successfully logged in.");
//		driver.findElement(By.className("logout-btn")).click();
		////*[contains(text(),'Out')] also works
		driver.findElement(By.xpath("//*[text()='Log Out']")).click(); 

		Thread.sleep(1000);
		
		driver.close();
	}

}
