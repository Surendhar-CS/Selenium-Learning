package seleniumFrameworkPractice.refactor.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumFrameworkPractice.data.ExcelUtility;

public class UploadDownloadTest{

	@Test
	public void Sampletest() throws IOException
	{	
			WebDriver driver=new EdgeDriver();
			driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.id("downloadButton")).click();
			String updateValue="700";
			
			ExcelUtility excel=new ExcelUtility();
			String file="C:\\Users\\SURA\\Downloads\\download.xlsx";
			int row=excel.getRowNumber(file, "kivi");
			int col=excel.getColumnNumber(file, "price");
			
			excel.updateCell(file, row, col, updateValue);
			
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(file);
			
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Toastify__toast-body")));
			System.out.println(driver.findElement(By.cssSelector(".Toastify__toast-body")).getText());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".Toastify__toast-body")));
		
			List<WebElement> fruitnames=driver.findElements(By.xpath("//div[contains(@class,'rdt_TableRow')]"));
			
			WebElement apple_price = fruitnames.stream().filter(n->n.findElement(By.xpath("./div[2]")).getText().equalsIgnoreCase("Kivi")).findFirst()
		    .orElse(null); 
			
			String actualValue=apple_price.findElement(By.xpath("./div[4]")).getText();
			
			Assert.assertEquals(updateValue, actualValue);
			System.out.println(actualValue);
			
	
			
			
	}
}
