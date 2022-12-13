package ExtentReportsDemo;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {
	ExtentReports extent;
	public ExtentTest logger;

	@BeforeTest
	public void startReport() {
		String date_num = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		System.out.println(date_num);
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(
				"./test-output/extentReport/IBM_ExtentReport_" + date_num + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		// Custom Report
		extent.setSystemInfo("Host Name", "Localhost");
		extent.setSystemInfo("Enviornment", "Production");
		extent.setSystemInfo("ExecutedBy", "Rajesh Singh");
		extent.setSystemInfo("Automation", "Functional/API");
		htmlReport.config().setDocumentTitle("IBM - functional automation/Api automation");
		htmlReport.config().setReportName("Regression Report");
		htmlReport.config().setTheme(Theme.DARK);
	}

	@Test
	public void verifyApplicationTitle() {
		logger = extent.createTest("To verify Google Title");
	}
	
	@Test
    public void verifyApplicationLogo() {
     logger = extent.createTest("To verify Application Logo");
    }
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
}
