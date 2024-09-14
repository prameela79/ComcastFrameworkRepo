package practice.contacttest;

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

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\commdata\\commondata.properties");
		Properties p1 = new Properties();
		p1.load(fis);
		String BROWSER = p1.getProperty("browser");
		String URL = p1.getProperty("url");
		String USERNAME = p1.getProperty("username");
		String PASSWORD = p1.getProperty("password");
		//generate the random num
		Random random = new Random();
		int randomint = random.nextInt(100);
		//read data from excel
		FileInputStream fis1 = new FileInputStream("C:\\Users\\HP\\Desktop\\Scriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(4);
		String lastname = row.getCell(2).getStringCellValue()+randomint;
		wb.close();
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
		Date dateobj = new Date();//CURRENT DATE
		//convert for required format
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		 String startdate = sim.format(dateobj);
		 //after 30 days date
		 Calendar cal = sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH,30);
		 String enddate = sim.format(cal.getTime());
		 //System.out.println(enddate);
		
		
		//enter all the details and create new organization
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
