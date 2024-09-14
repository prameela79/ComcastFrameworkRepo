package comcast.crm.pomImplementation;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic.FileUtilities.ExcelUtility;
import Generic.FileUtilities.FileUtility;
import Generic.WebDriverUtility.JavaUtility;
import ObjectRepositoryUtility.CreateContactbtnPage;
import ObjectRepositoryUtility.CreateNewcontactpage;
import ObjectRepositoryUtility.HomePage;
import ObjectRepositoryUtility.LoginPage;

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws Throwable {
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String BROWSER = flib.getDataFrompropertiesFile("browser");
		String URL = flib.getDataFrompropertiesFile("url");
		String USERNAME = flib.getDataFrompropertiesFile("username");
		String PASSWORD = flib.getDataFrompropertiesFile("password");

		// read data from excel

		String lastname = elib.getDataFromExcelFile("contact", 4, 2) + jlib.getRandomNum();

		WebDriver driver = null;
		if (BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// log in to the application
		LoginPage lp = new LoginPage(driver);
		lp.logintoapp(URL, USERNAME, PASSWORD);

		// step2 navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// click on create new contact button
		CreateContactbtnPage ccbp = new CreateContactbtnPage(driver);
		ccbp.getCreateNewcontactbtn().click();

		// enter all the details and create new contact
		String startdate = jlib.getSystemdate();
		String enddate = jlib.getRequiredDate(30);
		CreateNewcontactpage cnp = new CreateNewcontactpage(driver);
		cnp.CreateContactWithSupportDate(lastname, startdate, enddate);
		
		// verify last name
		String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actlastname.equals(lastname)) {
			System.out.println(lastname + " informaton is verified");
		} else {
			System.out.println(lastname + " informaton is not  verified");
		}
		// verify start date
		String actstartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actstartdate.equals(startdate)) {
			System.out.println(startdate + "actstartdate informaton is verified");
		} else {
			System.out.println(startdate + " actstartdate informaton is not  verified");
		}
		String actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actenddate.equals(enddate)) {
			System.out.println(enddate + "actenddate informaton is verified");
		} else {
			System.out.println(enddate + " informaton is not  verified");
		}
	}

}
