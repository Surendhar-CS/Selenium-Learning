package automationScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebTablesAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement table=driver.findElement(By.cssSelector("div .left-align #product tbody"));
		List<WebElement> tableRow = table.findElements(By.cssSelector("tr"));
		List<WebElement> tableColumn = table.findElements(By.cssSelector("tr:nth-child(3) td"));
		int rowCount=tableRow.size();
		int columnCount=tableColumn.size();
		System.out.println(rowCount);
		System.out.println(columnCount);
		for(int i=0;i<tableColumn.size();i++)
		{
			System.out.println(tableColumn.get(i).getText());
		}
		
		Thread.sleep(2000L);
		driver.quit();
	}

}
