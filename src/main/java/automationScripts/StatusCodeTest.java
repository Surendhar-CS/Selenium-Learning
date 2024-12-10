package automationScripts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class StatusCodeTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		String url=driver.findElement(By.partialLinkText("Broken")).getAttribute("href");
//		System.out.println(url);
//		
//		int statusCode = getStatusCode(url);
//		System.out.println(statusCode);
		
		//Implementation of softassertion
		
		SoftAssert sassertion=new SoftAssert();
		
		List<WebElement> links = driver.findElements(By.cssSelector(".gf-li a"));
		int statuscode=0;
		for(WebElement link:links)
		{
			statuscode=getStatusCode(link.getAttribute("href"));
			System.out.println(link.getAttribute("href"));
			System.out.println(statuscode);
			//softassertion to validate the status code
			sassertion.assertTrue(statuscode<400, "this link failed");
		}
		//Performing the assertion validation
		sassertion.assertAll();
		driver.quit();
	}

	public static int getStatusCode(String url) throws IOException, MalformedURLException, ProtocolException {
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int statusCode=conn.getResponseCode();
		return statusCode;
	}

	
	
}
