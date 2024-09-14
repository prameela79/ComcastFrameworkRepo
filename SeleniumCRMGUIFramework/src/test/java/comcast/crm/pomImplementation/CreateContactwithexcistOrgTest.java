package comcast.crm.pomImplementation;

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
import Generic.WebDriverUtility.WebDriverUtility;
import ObjectRepositoryUtility.CreateContactbtnPage;
import ObjectRepositoryUtility.CreateNewcontactpage;
import ObjectRepositoryUtility.CreatecontactselectExistOrgPage;
import ObjectRepositoryUtility.CreatingNewOrganizationPage;
import ObjectRepositoryUtility.HomePage;
import ObjectRepositoryUtility.LoginPage;
import ObjectRepositoryUtility.OrganizationsPage;

public class CreateContactwithexcistOrgTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib  =new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
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
		// log in to the application
		LoginPage lp = new LoginPage(driver);
		lp.logintoapp(URL, USERNAME, PASSWORD);
		
		//step2 navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		//click on create contact button
		OrganizationsPage onp = new OrganizationsPage(driver);
		onp.getCreateNeworgBtn().click();
		//enter all the details and create new organization
		CreatingNewOrganizationPage op = new CreatingNewOrganizationPage(driver);
		op.createorg(orgname);
		
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
		hp.getContactLink().click();
		//click on create contact button
		CreateContactbtnPage ccbp = new CreateContactbtnPage(driver);
		ccbp.getCreateNewcontactbtn().click();
		
		//enter all the details & create new contact
		CreateNewcontactpage cnp = new CreateNewcontactpage(driver);
		cnp.CreateContactWithOrg(orgname, lastname);
		wlib.switchtoTabOnUrl(driver, "module=Accounts");
		CreatecontactselectExistOrgPage cseorg = new CreatecontactselectExistOrgPage(driver);
		cseorg.selectExistOrg(orgname);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		//switch to parent window
		wlib.switchtoTabOnUrl(driver, "module=Contacts");
		cnp.getSavebtn().click();
		
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
