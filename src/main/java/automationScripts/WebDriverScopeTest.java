package automationScripts;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverScopeTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		
		int linkCount=driver.findElements(By.tagName("a")).size();
		System.out.println(linkCount);
		
//		System.out.println(driver.findElements(By.cssSelector("#gf-BIG a")).size());
		
		//limiting webdriver scope to the div with id #gf-BIG
		
		WebElement footerSection=driver.findElement(By.cssSelector("#gf-BIG"));
		System.out.println(footerSection.findElements(By.tagName("a")).size());
		
	WebElement column=footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int columnSize=column.findElements(By.tagName("a")).size();
		
		Actions mouse=new Actions(driver);
		System.out.println(columnSize);
		for(int i=1;i<columnSize;i++)
		{
			
//			mouse.keyDown(Keys.CONTROL).click(column.findElements(By.tagName("a")).get(i)).build().perform();
//			driver.navigate().back();
			String charSeq=Keys.chord(Keys.CONTROL,Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(charSeq);
			
		}
		Set<String> openedTabs=driver.getWindowHandles();
		Iterator<String> ite=openedTabs.iterator();
		ite.next();
		while(ite.hasNext())
		{
			driver.switchTo().window(ite.next());
			System.out.println(driver.getTitle());
		}
		
		
		Thread.sleep(3000L);
		driver.quit();
	}

}
