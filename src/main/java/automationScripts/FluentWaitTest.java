package automationScripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(3));
//			.ignoring(NoSuchElementException.class);
	
	WebElement msg= wait.until(new Function<WebDriver, WebElement>(){
		public WebElement apply(WebDriver driver)
		{
			WebElement msg=driver.findElement(By.cssSelector("[id='finish'] h4"));
			if(msg.isDisplayed())
			{
				return msg;
			}
			else
			{
				return null;
			}
		}
		
	}
		);
			System.out.println(msg.getText());
		
			
			driver.quit();
	}

}
