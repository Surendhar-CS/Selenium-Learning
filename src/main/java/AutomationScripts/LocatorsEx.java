package AutomationScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LocatorsEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SURA\\Documents\\Selenium QA\\seleniumQA\\src\\main\\resources\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement Username=driver.findElement(By.id("inputUsername"));
		Username.sendKeys("suratest");
		WebElement Password=driver.findElement(By.name("inputPassword"));
		Password.sendKeys("1234");
		WebElement SigninBtn=driver.findElement(By.className("signInBtn"));
		SigninBtn.click();
		WebElement errormsg=driver.findElement(By.cssSelector("p.error"));
		System.out.println(errormsg.getText());
		
		WebElement forgotPassword=driver.findElement(By.linkText("Forgot your password?"));
		forgotPassword.click();
		WebElement resetUser=driver.findElement(By.xpath("//input[@placeholder='Name']"));
		resetUser.sendKeys("suratest");
		WebElement resetEmail=driver.findElement(By.cssSelector("input[placeholder='Email']"));
		resetEmail.sendKeys("1234");
		
		WebElement resetPhno=driver.findElement(By.xpath("//form/input[3]"));
		resetPhno.sendKeys("1234567890");
		Thread.sleep(1000);
		WebElement resetLoginBtn=driver.findElement(By.cssSelector(".reset-pwd-btn"));
//		WebElement resetLoginBtn=driver.findElement(By.xpath("//div/button[2]"));
		resetLoginBtn.click();
		
		WebElement resetErrorMsg=driver.findElement(By.cssSelector("form p"));
		String resetMsg=resetErrorMsg.getText();
		System.out.println(resetMsg);
		WebElement gotoLoginBtn=driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]"));
		gotoLoginBtn.click();	
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("suratest");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//label[@for='chkboxOne']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		Thread.sleep(1000);
		
		driver.close();
	}

}
