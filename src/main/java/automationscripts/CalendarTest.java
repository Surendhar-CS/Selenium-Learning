package automationscripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String monthNumber = "9";
		String date = "24";
		String year = "2024";
		String[] ExpectedList= {monthNumber,date,year};

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector("button[class='react-calendar__navigation__label']")).click();
		driver.findElement(By.cssSelector("button[class='react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']["
				+ monthNumber + "]")).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

		List<WebElement> actualList=driver.findElements(By.className("react-date-picker__inputGroup__input"));
		for(int i=0;i<actualList.size();i++)
		{
			System.out.println(actualList.get(i).getAttribute("value"));
			Assert.assertEquals(actualList.get(i).getAttribute("value"), ExpectedList[i]);
			
		}
		
		Thread.sleep(3000L);
		driver.quit();
	}

}
