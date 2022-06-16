package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extentReport;
	
	public static ExtentReports getReportOject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("E2E report");
		reporter.config().setDocumentTitle("E2E report doc");
		
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		return extentReport;
		
	}
}
