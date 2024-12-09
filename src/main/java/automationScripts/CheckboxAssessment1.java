package automationScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssessment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				WebElement chkbox=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
				chkbox.click();
				Assert.assertTrue(chkbox.isSelected());
				chkbox.click();
				Assert.assertFalse(chkbox.isSelected());
				System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
				
				
				 
				
				
				
				
				Thread.sleep(1000);
				
				driver.quit();
	}

}
