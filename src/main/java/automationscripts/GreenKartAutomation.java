package automationscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class GreenKartAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		List<WebElement> Products=driver.findElements(By.className("product-name"));
		
		for(int i=0;i<Products.size();i++)
		{
			String name=Products.get(i).getText();
			if(name.contains("Cucumber"))
			{
				driver.findElements(By.xpath("//button[contains(text(),'ADD')]")).get(i).click();
				break;
			}
		}
		Thread.sleep(2000L);
		driver.quit();
	}

}
