package comcast.crm.pomImplementation;

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

import com.comcast.crm.baseTest.BaseClass;

import Generic.FileUtilities.ExcelUtility;
import Generic.FileUtilities.FileUtility;
import Generic.WebDriverUtility.JavaUtility;
import ObjectRepositoryUtility.CreateContactbtnPage;
import ObjectRepositoryUtility.CreateNewcontactpage;
import ObjectRepositoryUtility.HomePage;
import ObjectRepositoryUtility.LoginPage;

public class CreatecontactTest extends BaseClass {
		@Test
		public void createcontacTtest() throws Throwable {
			
			//read data from excel
			String lastname = elib.getDataFromExcelFile("contact", 1, 2)+jlib.getRandomNum();
			
//			log in in to the application
//			LoginPage lp = new LoginPage(driver);
//			lp.logintoapp(URL, USERNAME, PASSWORD);
			
			//step2 navigate organization module
			HomePage hp = new HomePage(driver);
			hp.getContactLink().click();
			
			//click on create new contact button
			CreateContactbtnPage ccbp = new CreateContactbtnPage(driver);
			ccbp.getCreateNewcontactbtn().click();
			
			
			//enter all the details and create new organization
			CreateNewcontactpage cnp = new CreateNewcontactpage(driver);
			cnp.createNewcontact(lastname);
			
			//verify the contact name 
		     String actcontact = driver.findElement(By.id("dtlview_Last Name")).getText();
		     if(actcontact.equals(lastname))
		    	 System.out.println(actcontact+"actcontact is verified ---pass");
		     else
		    	 System.out.println(actcontact+"actcontact is  not verified ---pass");
			/*step5 logout
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();*/
			
		

	}


}
