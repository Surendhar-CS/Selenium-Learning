package AutomationScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverScopeAssessment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement checkboxDiv=driver.findElement(By.id("checkbox-example"));
        checkboxDiv.findElement(By.xpath("//label[@for='benz']/input")).click();
        String value=checkboxDiv.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(value);
		
		Select dropdown=new Select(driver.findElement(By.id("dropdown-class-example")));
		
		dropdown.selectByVisibleText(value);
		
		driver.findElement(By.id("name")).sendKeys(value);
		driver.findElement(By.id("alertbtn")).click();
		String alertMsg=driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		System.out.println(alertMsg.contains(value));
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000L);
		driver.quit();
	}

}
