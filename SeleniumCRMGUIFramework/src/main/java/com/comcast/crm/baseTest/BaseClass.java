package com.comcast.crm.baseTest;

import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Generic.DataBaseUtility.DataBaseUtility;
import Generic.FileUtilities.ExcelUtility;
import Generic.FileUtilities.FileUtility;
import Generic.WebDriverUtility.JavaUtility;
import Generic.WebDriverUtility.UtilityclassObject;
import Generic.WebDriverUtility.WebDriverUtility;
import ObjectRepositoryUtility.HomePage;
import ObjectRepositoryUtility.LoginPage;


public class BaseClass {
	public WebDriver driver =null;
	public static WebDriver sdriver =null;
	/* create object*/
	public DataBaseUtility dlib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	
	@BeforeSuite(groups = {"smokeTesting","RegressionTesting"})
	public void configBS() throws SQLException {
		System.out.println("-----connect to db,report config-----");
		dlib.getDBConnection();
		
	}
	@BeforeClass(groups = {"smokeTesting","RegressionTesting"})
	public void configBC() throws Throwable {
		System.out.println("--launch browser----");
		String BROWSER = flib.getDataFrompropertiesFile("browser");

		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver =new EdgeDriver();
		}
		sdriver=driver;
		UtilityclassObject.setDriver(driver);
		
	}
	
	@BeforeMethod(groups = {"smokeTesting","RegressionTesting"})
	public void configbm() throws Throwable {
		System.out.println("--login to application---");
		String url = flib.getDataFrompropertiesFile("url");
		String USERNAME = flib.getDataFrompropertiesFile("username");
		String PASSWORD = flib.getDataFrompropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.logintoapp(url, USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups = {"smokeTesting","RegressionTesting"})
	public void configam() {
		System.out.println("---logout-----");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups = {"smokeTesting","RegressionTesting"})
	public void configAC() {
		System.out.println("----close browser---");
		driver.quit();
		
	}
	
	@AfterSuite(groups = {"smokeTesting","RegressionTesting"})
	public void configAS() throws SQLException {
		System.out.println("----close db,report backup---");
		dlib.closeDBconnection();
		
	}

}
