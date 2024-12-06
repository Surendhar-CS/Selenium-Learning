package AutomationScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://spicejet.com");
		
		WebElement fromDropdown=driver.findElement(By.xpath("//div[text()='From']"));
		fromDropdown.click();
		
		driver.findElement(By.xpath("//div[text()='MAA']")).click();
		Thread.sleep(1000);
		
		driver.close();
		
	}	

}
