package PracticeGenericUtility.Createcontact;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic.FileUtilities.ExcelUtility;
import Generic.FileUtilities.FileUtility;
import Generic.WebDriverUtility.JavaUtility;

public class CreatecontactTestwithUtility {
		@Test
		public void createcontacTtest() throws Throwable {
			FileUtility flib = new FileUtility();
			ExcelUtility elib = new ExcelUtility();
			JavaUtility jlib  =new JavaUtility();
			String BROWSER = flib.getDataFrompropertiesFile("browser");
			String URL = flib.getDataFrompropertiesFile("url");
			String USERNAME = flib.getDataFrompropertiesFile("username");
			String PASSWORD = flib.getDataFrompropertiesFile("password");
			
			//read data from excel
			String lastname = elib.getDataFromExcelFile("contact", 1, 2)+jlib.getRandomNum();
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
