package Practice_ExtentReport;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class sample_ExtentReport {
	ExtentReports report;
	@BeforeSuite
	public void configBF() {
		// spark report configuration
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// Add environment information and create test
	    report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chrome-100");

	}
	@AfterSuite
	public void configAS() {
		report.flush();
		
	}

	@Test
	public void createContact() {

		ExtentTest test = report.createTest("createcontactTest");

		test.log(Status.INFO, "Login to application");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
		
	}
	@Test
	public void createContactWithORG() {
		
		

		ExtentTest test = report.createTest("createContactWithORG");

		test.log(Status.INFO, "Login to application");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
		
	}
	
	@Test
	public void createContactWithPhoneNum() {

		ExtentTest test = report.createTest("createContactWithPhoneNum");

		test.log(Status.INFO, "Login to application");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
		
	}
}
