package comcast.crm.pomImplementation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic.FileUtilities.ExcelUtility;
import Generic.FileUtilities.FileUtility;
import Generic.WebDriverUtility.JavaUtility;
import Generic.WebDriverUtility.WebDriverUtility;
import ObjectRepositoryUtility.CreatingNewOrganizationPage;
import ObjectRepositoryUtility.HomePage;
import ObjectRepositoryUtility.LoginPage;
import ObjectRepositoryUtility.OrganizationInfoPage;
import ObjectRepositoryUtility.OrganizationsPage;

public class DeleteOrg {
	@Test
	public void createOrgtest() throws Throwable {
		//read data from property
		FileUtility flib = new FileUtility(); 
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		String BROWSER = flib.getDataFrompropertiesFile("browser");
		String URL = flib.getDataFrompropertiesFile("url");
		//String USERNAME = flib.getDataFrompropertiesFile("username");
		// String PASSWORD = flib.getDataFrompropertiesFile("password");
		//read data from excel

		String orgname = elib.getDataFromExcelFile("org", 10, 2)+jlib.getRandomNum();
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
		
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNeworgBtn().click();
		
		//enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createorg(orgname);
		
		//verify header msg expected result
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actorgName = oip.getHeadermsg().getText();
		if(actorgName.contains(orgname))
			System.out.println("orgname is verified");
		else
			System.out.println("orgname is not verified");
		
		//go back to org page
		hp.getOrgLink().click();
		
		//search for organization 
		cnp.getSearchEdt().sendKeys(orgname);
		wlib.select(cnp.getSearchDD(), "Organization Name");
		cnp.getSearchBtn().click();
		
		
		//in dynamic web table select org and delete
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		driver.switchTo().alert().accept();
		//logout
		hp.logout();
		driver.quit();
		
	}

}
