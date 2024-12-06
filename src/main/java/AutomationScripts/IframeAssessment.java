package AutomationScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class IframeAssessment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		WebElement iframe=driver.findElement(By.cssSelector("frame[name='frame-top']"));
		
		driver.switchTo().frame(iframe);

		WebElement middleIframe=driver.findElement(By.cssSelector("frame[name='frame-middle']"));
		
		driver.switchTo().frame(middleIframe);
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
	
		
		Thread.sleep(3000L);
		driver.quit();
	}

}
