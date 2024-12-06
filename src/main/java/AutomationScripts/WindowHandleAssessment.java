package AutomationScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandleAssessment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.cssSelector("#content a")).click();
		Set<String> windowsList=driver.getWindowHandles();
		Iterator<String> it=windowsList.iterator();
		String parentID=it.next();
		String childID=it.next();
		
		driver.switchTo().window(childID);
		
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		
		driver.switchTo().window(parentID);
		
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		
		Thread.sleep(3000L);
		driver.quit();
	
	}

}
