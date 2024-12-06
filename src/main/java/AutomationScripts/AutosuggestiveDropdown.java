package AutomationScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutosuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\SURA\\Documents\\Selenium QA\\seleniumQA\\src\\main\\resources\\drivers\\chromedriver.exe");

		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("in");
		Thread.sleep(2000L);
		
		List<WebElement> autodropvalues=driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"]/a"));
		
		for(WebElement option: autodropvalues)
		{
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
				
		}
		Thread.sleep(2000L);
		
		
	
		
		
		
		
		driver.close();
		}

}
