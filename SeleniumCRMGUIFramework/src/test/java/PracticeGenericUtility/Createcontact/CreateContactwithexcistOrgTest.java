package PracticeGenericUtility.Createcontact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactwithexcistOrgTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib  =new JavaUtility();
		String BROWSER = flib.getDataFrompropertiesFile("browser");
		String URL = flib.getDataFrompropertiesFile("url");
		String USERNAME = flib.getDataFrompropertiesFile("username");
		String PASSWORD = flib.getDataFrompropertiesFile("password");
		
		//read data from excel
		
		String orgname = elib.getDataFromExcelFile("contact", 7, 2)+jlib.getRandomNum();
		String lastname = elib.getDataFromExcelFile("contact", 7, 3)+jlib.getRandomNum();
		
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
		driver.findElement(By.linkText("Organizations")).click();
		//click on create organization button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//enter all the details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// verify header info expected result
		String headerinfo =  driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgname))
			System.out.println(orgname+" is created");
		else
			System.out.println(orgname+"is not created fail" );
		
		//verify header org name info expected result
		String actorgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actorgname);
		if(actorgname.trim().equals(orgname))
			System.out.println(orgname+" information is verified");
		else
			System.out.println(orgname+" information is not verified fail" );
		//navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//enter all the details & create new organization
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
		Set<String> winID = driver.getWindowHandles();
		Iterator<String> it = winID.iterator();
		while(it.hasNext())
	    {
			driver.switchTo().window(it.next());
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("module=Accounts")) {
				break;
			}
	    }
		
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		// switch back to parent window
		Set<String> winID1 = driver.getWindowHandles();
		Iterator<String> it1 = winID1.iterator();
		while(it1.hasNext())
	    {
			driver.switchTo().window(it1.next());
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("module=Contacts")) {
				break;
			}
	    }
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify header message
	    headerinfo =  driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(lastname))
			System.out.println(lastname+" is verified");
		else
			System.out.println(orgname+"is not verified fail" );
		//verify existed org name after save data flow happpening
		String exporg = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(exporg.equals(orgname))
			System.out.println(orgname+" expected org name is verified");
		else
			System.out.println(orgname+" expected org name is verified");
		
		driver.close();
		

	}

}
