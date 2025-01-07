package seleniumFrameworkPractice.refactor.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

	public static ExtentReports getExtentReportsObject()
	{
		String reportPath=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		ExtentReports extent = new ExtentReports();
		reporter.config().setDocumentTitle("Test Results");
		extent.attachReporter(reporter);
		return extent;
	}
}
