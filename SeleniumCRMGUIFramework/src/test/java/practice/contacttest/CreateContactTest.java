package practice.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactTest {
	@Test
	public void createcontacTtest() throws Throwable {
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
		FileInputStream fis1 = new FileInputStream("C:\\Users\\HP\\Desktop\\scriptdata\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(1);
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
		
		//enter all the details and create new organization
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify the header phone number info expected result
		String headerinfo =  driver.findElement(By.id("dvHeaderText")).getText();
		
		//verify the contact name 
	     String actcontact = driver.findElement(By.id("dtlview_Last Name")).getText();
	     if(actcontact.equals(lastname))
	    	 System.out.println(actcontact+"actcontact is verified ---pass");
	     else
	    	 System.out.println(actcontact+"actcontact is  not verified ---pass");
		//step5 logout
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

}
