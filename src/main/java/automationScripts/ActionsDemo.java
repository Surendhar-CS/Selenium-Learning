package automationScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			WebDriver driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.in/");
			
			Actions mouse=new Actions(driver);
			WebElement dropdown = driver.findElement(By.cssSelector("#nav-link-accountList"));
			
			
			mouse.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox")))
			.click().keyDown(Keys.SHIFT).doubleClick()
			.sendKeys("hello").build().perform();
			
			
			mouse.moveToElement(dropdown).contextClick().build().perform();
			
			
			
			
			
			Thread.sleep(2000L);
			driver.quit();
	}

}
