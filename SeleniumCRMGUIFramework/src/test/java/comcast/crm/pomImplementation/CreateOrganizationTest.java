package comcast.crm.pomImplementation;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.time.Duration;
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
import ObjectRepositoryUtility.CreatingNewOrganizationPage;
import ObjectRepositoryUtility.HomePage;
import ObjectRepositoryUtility.LoginPage;
import ObjectRepositoryUtility.OrganizationInfoPage;
import ObjectRepositoryUtility.OrganizationsPage;

public class CreateOrganizationTest {
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//rule 3 object initialization
		 LoginPage lp = new LoginPage(driver);
		 
		 //rule-5 object utilization
		 /*lp.getUsernameEdit().sendKeys("admin");
		 lp.getPasswordEdit().sendKeys("admin");
		 lp.getLoginBtn().click();*/
		  
		 lp.logintoapp("admin", "admin", URL);
	
		//step2 navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		//click on create organization button
		
		OrganizationsPage og = new OrganizationsPage(driver);
		og.getCreateNeworgBtn().click();
		
		//enter all the details and create new organization
		CreatingNewOrganizationPage op = new CreatingNewOrganizationPage(driver);
		op.createorg(orgname);
		
		//verify header msg expected result
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actorgName = oip.getHeadermsg().getText();
		if(actorgName.contains(orgname))
			System.out.println("orgname is verified");
		else
			System.out.println("orgname is not verified");
		//logout
		hp.logout();
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
		String USERNAME =flib.getDataFrompropertiesFile("username");
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
		// log in to the app
		LoginPage lp = new LoginPage(driver);
		lp.logintoapp(URL, USERNAME, PASSWORD);
		
		//step2 navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		//enter all the details and create new organization
		CreatingNewOrganizationPage op = new CreatingNewOrganizationPage(driver);
		op.createorg(orgname);
		op.createOrg(orgname, industry);
		op.CreateOrg(orgname, type);
		
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
		String phonenum  = elib.getDataFromExcelFile("org", 7, 3);
		
		WebDriver driver =null;
		if(BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if(BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//log in to the application
		LoginPage lp = new LoginPage(driver);
		lp.logintoapp(URL, USERNAME, PASSWORD);
		
		//step2 navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		//enter all the details and create new organization
		CreatingNewOrganizationPage op = new CreatingNewOrganizationPage(driver);
		op.createorg(orgname);
		op.getPhonenum().sendKeys(phonenum);
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
