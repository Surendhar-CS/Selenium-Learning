package automationScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		 Set<String> windows=driver.getWindowHandles();
		 Iterator<String> it=windows.iterator();
		 String parentID=it.next();
		 String childID=it.next();
		 
		 driver.switchTo().window(childID);
		 
		 String email=driver.findElement(By.cssSelector("p.im-para.red a")).getText();
		 driver.findElement(By.cssSelector("p.im-para.red a")).getText();
		 System.out.println(email);
		 	
		 driver.switchTo().window(parentID);
		 driver.findElement(By.id("username")).sendKeys(email);
		 
		Thread.sleep(2000L);
		driver.quit();
	}

}
