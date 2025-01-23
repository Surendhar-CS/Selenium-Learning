package automationscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class IframesTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement iframe=driver.findElement(By.cssSelector(".demo-frame"));
		
		driver.switchTo().frame(iframe);

		WebElement draggableElement=driver.findElement(By.cssSelector("#draggable"));
		WebElement droppableElement = driver.findElement(By.cssSelector("#droppable"));
		System.out.println(draggableElement.getText());
		
		System.out.println(droppableElement.getText());
		
		Actions a=new Actions(driver);
		a.dragAndDrop(draggableElement, droppableElement).build().perform();
		
		System.out.println(droppableElement.getText());
		
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > p:nth-child(8)")).getText());
		Thread.sleep(3000L);
		driver.quit();
		
		
	}

}
