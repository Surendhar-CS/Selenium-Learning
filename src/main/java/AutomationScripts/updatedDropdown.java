package AutomationScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class updatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://spicejet.com");
		
		WebElement passengerDropdown=driver.findElement(By.xpath("//div[contains(text(),'Adult')]"));
		passengerDropdown.click();
		System.out.println(passengerDropdown.getText());
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.xpath("//div[contains(@data-testid,'plus-one')]")).click();
		}
		
		System.out.println(passengerDropdown.getText());
		
		
		Thread.sleep(1000);
		driver.close();
		
	}

}
