package PracticeGenericUtilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic.FileUtilities.ExcelUtility;
import Generic.FileUtilities.FileUtility;
import Generic.WebDriverUtility.JavaUtility;

public class CreateorgByUsingGenericUtility {
	@Test
	public void createOrgtest() throws Throwable {
		//read data from property
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String BROWSER = flib.getDataFrompropertiesFile("browser");
		String URL = flib.getDataFrompropertiesFile("url");
		String USERNAME = flib.getDataFrompropertiesFile("username");
		String PASSWORD = flib.getDataFrompropertiesFile("password");
		//read data from excel
		
		String orgname = elib.getDataFromExcelFile("org", 1, 2)+jlib.getRandomNum();
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
		//verify header msg expected result
		String headerinfo =  driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgname))
			System.out.println(orgname+" is created");
		else
			System.out.println(orgname+"is not created fail" );
		//verify header org name info expected result
		String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actorgname.equals(orgname))
			System.out.println(orgname+" information is created");
		else
			System.out.println(orgname+" information is not created fail" );
		//step5 logout
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

	
	@Test
	public void createOrgWithIndustrytest() throws Throwable {
		//read data from property
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String BROWSER = flib.getDataFrompropertiesFile("browser");
		String URL = flib.getDataFrompropertiesFile("url");
		String USERNAME = flib.getDataFrompropertiesFile("username");
		String PASSWORD = flib.getDataFrompropertiesFile("password");
		//read data from excel
		
		String orgname = elib.getDataFromExcelFile("org", 4, 2)+jlib.getRandomNum();
		String industry = elib.getDataFromExcelFile("org", 4, 3);
		String type = elib.getDataFromExcelFile("org", 4, 4);
		
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
		WebElement ele = driver.findElement(By.name("industry"));
		Select sel = new Select(ele);
		sel.selectByVisibleText(industry);
		WebElement ele1 = driver.findElement(By.name("accounttype"));
		Select sel2 = new Select(ele1);
		sel2.selectByVisibleText(type);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify the industries and type info
		String actindustry =  driver.findElement(By.id("dtlview_Industry")).getText();
		if(actindustry.equals(industry))
			System.out.println(actindustry+"industry info is verified");
		else
			System.out.println(orgname+"industry info is not verified" );
		//verify type info
		String acttype = driver.findElement(By.id("dtlview_Type")).getText();
		if(acttype.equals(type))
			System.out.println(orgname+" type info is verified");
		else
			System.out.println(orgname+" type info is not verified fail" );
		//step5 logout
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}
	
	@Test
	public void createOrgWithphonenumber() throws Throwable {
		//read data from property
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String BROWSER = flib.getDataFrompropertiesFile("browser");
		String URL = flib.getDataFrompropertiesFile("url");
		String USERNAME = flib.getDataFrompropertiesFile("username");
		String PASSWORD = flib.getDataFrompropertiesFile("password");
		//read data from excel

		String orgname = elib.getDataFromExcelFile("org", 7, 2)+jlib.getRandomNum();
		String phonenum = elib.getDataFromExcelFile("org", 7, 3);
		//String type = row.getCell(4).getStringCellValue();
		
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
		driver.findElement(By.id("phone")).sendKeys(phonenum);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify the header phone number info expected result
		String actphonenum =  driver.findElement(By.id("dtlview_Phone")).getText();
		if(actphonenum.equals(phonenum))
			System.out.println(actphonenum+"actphonenum info is verified");
		else
			System.out.println(actphonenum+"actphonenum info is not verified" );
		//step5 logout
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

}
