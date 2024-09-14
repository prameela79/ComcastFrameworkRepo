package com.comcast.crm.ListenerUtility;

import java.io.File;
 
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseTest.BaseClass;

import Generic.WebDriverUtility.UtilityclassObject;

public class listimpclass implements ITestListener,ISuiteListener  {
	public static  ExtentReports report;
	public static ExtentTest test;
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		//spark report config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark  =new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite");
		spark.config().setReportName("CRM Result");
		spark.config().setTheme(Theme.DARK);
		
		//add environment information and create test
		 report = new ExtentReports();
		 report.attachReporter(spark);
		 report.setSystemInfo("os", "Windows-10");
		 report.setSystemInfo("Browser", "Chrome");	
	}
	
  public void onFinish(ISuite suite) {
	  System.out.println("Report Backup");
	  report.flush();
	}
  public void onTestStart(ITestResult result) {
	  System.out.println("--->"+result.getMethod().getMethodName()+"--START-->");
	   test = report.createTest(result.getMethod().getMethodName());
	   UtilityclassObject.setTest(test);
	   test.log(Status.INFO, result.getMethod().getMethodName()+"Started");
  }
  public void onTestSuccess(ITestResult result) {
	  System.out.println("--->"+result.getMethod().getMethodName()+"--END-->");
	  test.log(Status.PASS, result.getMethod().getMethodName()+"COMPLETED");
  }
  public void onTestFailure(ITestResult result) {
	  String TestName = result.getMethod().getMethodName();
	  String time = new Date().toString().replace(" ", "_").replace(":", "_");
	  TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
	  String filepath = ts.getScreenshotAs(OutputType.BASE64);//it return screenshot store in file class
	//Attach screenshot to report
	  test.addScreenCaptureFromBase64String(filepath,TestName+"_"+time);
	  test.log(Status.FAIL, result.getMethod().getMethodName()+"FAILED");
		/*
		 * //copy the screen shot in or required path File perm = new
		 * File("./Screenshot/"+TestName+"+"+time+".png");
		 * 
		 * //copy the source file to destination file try { FileHandler.copy(term,
		 * perm); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		//Attach screenshot to report
		test.addScreenCaptureFromBase64String(filepath,"Errorfile");
  }
  
public void onTestSkipped(ITestResult result) {
	  
  }
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	  
}
}
