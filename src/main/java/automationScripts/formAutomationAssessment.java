package automationScripts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class formAutomationAssessment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Sura");
		driver.findElement(By.name("email")).sendKeys("sura@test.me");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password@123");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		Select dropdown=new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		
		//dropdown.selectByValue("Female") doesnt work here coz selenium will look for Value attribute in the  Select element
		dropdown.selectByVisibleText("Female");
		List<WebElement> ls=dropdown.getOptions();
		
		for(WebElement itr:ls)
		{
			System.out.println(itr.getText());
		}
		
		driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("22072000");
		driver.findElement(By.className("btn-success")).click();
		
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		
			
		
	
		
		
		
		Thread.sleep(2000L);

		driver.close();
	}

}
