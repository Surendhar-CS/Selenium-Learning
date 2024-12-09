package automationScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SSLChecks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		EdgeOptions options=new EdgeOptions();
		
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver=new EdgeDriver(options);
		driver.manage().window().maximize();
	
		//code to change the download directory by using Experimental option
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(2000L);
		driver.quit();
	}

}
