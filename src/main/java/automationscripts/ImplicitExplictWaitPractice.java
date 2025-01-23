package automationscripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitExplictWaitPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("learning");
		
		driver.findElement(By.xpath("//input[@value='user']")).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"okayBtn\"]")));
		driver.findElement(By.xpath("//button[@id=\"okayBtn\"]")).click();
		
		
		Select dropdown=new Select(driver.findElement(By.tagName("select")));
		
		dropdown.selectByValue("consult");
		
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("app-card div.card")));
		List<WebElement> productCards=driver.findElements(By.cssSelector("app-card div.card"));
		
		
		
	
		System.out.println(productCards.size());
		
		for(int i=0;i<productCards.size();i++)
		{
			System.out.println(driver.findElements(By.cssSelector("app-card div.card a")).get(i).getText());
			driver.findElements(By.cssSelector("app-card div.card button")).get(i).click();
			
		}
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		Thread.sleep(5000L);
		driver.quit();
	}

}
