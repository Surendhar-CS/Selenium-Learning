package automationscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class passwordParser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SURA\\Documents\\Selenium QA\\seleniumQA\\src\\main\\resources\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		
		WebElement forgotPassword=driver.findElement(By.linkText("Forgot your password?"));
		forgotPassword.click();
	
		
		WebElement resetLoginBtn=driver.findElement(By.cssSelector(".reset-pwd-btn"));
//		WebElement resetLoginBtn=driver.findElement(By.xpath("//div/button[2]"));
		resetLoginBtn.click();
		
		WebElement resetErrorMsg=driver.findElement(By.cssSelector("form p"));
		String resetMsg=resetErrorMsg.getText();
		System.out.println(resetMsg);
		
		
		
		
		
		
		
		Thread.sleep(1000);
		
		driver.close();
	}

}
