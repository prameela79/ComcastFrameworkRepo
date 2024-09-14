package PracticeGenericUtility.Createcontact;

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

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws Throwable {
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib  =new JavaUtility();
		String BROWSER = flib.getDataFrompropertiesFile("browser");
		String URL = flib.getDataFrompropertiesFile("url");
		String USERNAME = flib.getDataFrompropertiesFile("username");
		String PASSWORD = flib.getDataFrompropertiesFile("password");
		
		//read data from excel
		
		String lastname = elib.getDataFromExcelFile("contact", 4, 2)+jlib.getRandomNum();
		
		WebDriver driver =null;
		if(BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if(BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step2 navigate organization module
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on contact organization button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//date format start date and end date
		String startdate = jlib.getSystemdate();
		 //after 30 days date
		 String enddate = jlib.getRequiredDate(30);
		 
		//enter all the details and create new contact
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		//locate start date
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate) ;
		//locate end date
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate) ;
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify last name
		String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText(); 
		if(actlastname.equals(lastname)) {
			System.out.println(lastname + " informaton is verified");
			}
		else {
			System.out.println(lastname + " informaton is not  verified");	
		}
		//verify start date
		String actstartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstartdate.equals(startdate)) {
			System.out.println(startdate + "actstartdate informaton is verified");
			}
		else {
			System.out.println(startdate + " actstartdate informaton is not  verified");	
		}
		String actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actenddate.equals(enddate)) {
			System.out.println(enddate + "actenddate informaton is verified");
			}
		else {
			System.out.println(enddate + " informaton is not  verified");	
		}
	}

}
