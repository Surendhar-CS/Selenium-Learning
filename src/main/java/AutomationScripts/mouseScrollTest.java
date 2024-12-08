package AutomationScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class mouseScrollTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor)(driver);
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=100");
		
		List<WebElement> tableRows=driver.findElements(By.xpath("//div[@class=\"tableFixHead\"]/table/tbody/tr/td[4]"));
		int sum=0;
		for(int i=0;i<tableRows.size();i++)
		{
			sum+=Integer.parseInt(tableRows.get(i).getText());
			
		}
		System.out.println(sum);
		int actualSum=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ")[1]);
		System.out.println(actualSum);
		Assert.assertEquals(sum, actualSum);
		Thread.sleep(2000L);
		driver.quit();
	}

}
