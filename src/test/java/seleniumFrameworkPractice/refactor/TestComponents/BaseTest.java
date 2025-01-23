package seleniumFrameworkPractice.refactor.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import seleniumFrameworkPractice.data.DataReader;
import seleniumFrameworkPractice.refactor.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver IntializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream ios = new FileInputStream(new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\seleniumFrameworkPractice\\refactor\\resources\\application.properties"));
		prop.load(ios);

		String BrowserName=System.getProperty("browserName")==null?prop.getProperty("browser"):System.getProperty("browserName");

		if (BrowserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BrowserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = IntializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}

	@AfterMethod(alwaysRun = true)
	public void closeApplication() {
		driver.quit();
	}
	
	public  List<HashMap<String, String>> getDataReader(String filename) throws IOException
	{
		DataReader reader=new DataReader();
	return	reader.getJsonData(filename);
	}
	
	public String  getScreenshot(String testcasename,WebDriver driver) throws IOException
	{
		
	TakesScreenshot ts=	(TakesScreenshot)driver;
	File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
	FileUtils.copyFile(screenshotAs, file);
	System.out.println(file.getPath());
	return file.getPath();
	
	}
	
}
