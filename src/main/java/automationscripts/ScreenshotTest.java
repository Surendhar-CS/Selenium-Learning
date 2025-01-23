package automationscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class ScreenshotTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		EdgeOptions options = new EdgeOptions();

		options.setAcceptInsecureCerts(true);

		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

		File file = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./screenshots/screenshot1.png"));

		Thread.sleep(2000L);
		driver.quit();
	}

}
