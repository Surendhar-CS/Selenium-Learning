package AutomationScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String text = "SURA";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		String alertmsg = driver.switchTo().alert().getText();
		System.out.println(alertmsg);
		System.out.println(alertmsg.contains(text));
		Thread.sleep(2000L);
		driver.switchTo().alert().dismiss();

//	driver.findElement(By.cssSelector("#confirmbtn")).click();
//	Thread.sleep(2000L);
//	driver.switchTo().alert().dismiss();
//	
		Thread.sleep(2000L);
		driver.quit();

	}

}
