package Practice_AttachScreenshot_TO_ExtentReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AttachScreenshot_TO_Report {
	ExtentReports report;
	@BeforeSuite
	public void configBs() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		report =new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chrome");
	}
	@Test
	public void createcontact() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		TakesScreenshot ts= (TakesScreenshot)driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		ExtentTest test = report.createTest("createcontactTest");
		test.log(Status.INFO, "Login to APP");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDC")) {
			test.log(Status.PASS, "contact is created");
		}
		else {
		test.addScreenCaptureFromBase64String(filepath,"ErrorFile");
		}
		driver.close();	
	}
	@AfterSuite
	public void configAS() {
		report.flush();
	}

}
