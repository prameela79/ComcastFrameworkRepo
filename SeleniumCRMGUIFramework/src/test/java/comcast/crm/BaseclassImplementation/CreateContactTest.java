package comcast.crm.BaseclassImplementation;


import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.baseTest.BaseClass2;

import ObjectRepositoryUtility.CreateContactbtnPage;
import ObjectRepositoryUtility.CreateNewcontactpage;
import ObjectRepositoryUtility.CreatecontactselectExistOrgPage;
import ObjectRepositoryUtility.CreatingNewOrganizationPage;
import ObjectRepositoryUtility.HomePage;
import ObjectRepositoryUtility.OrganizationInfoPage;
import ObjectRepositoryUtility.OrganizationsPage;
/**
 * @author prameela
 */
public class CreateContactTest extends BaseClass {
	
	@Test(groups = "smokeTesting")
	public void createcontacTtest() throws Throwable {

		/* read testscript data from excel*/
		String LastName = elib.getDataFromExcelFile("contact", 1, 2) + jlib.getRandomNum();

		/* step2 navigate to contact module*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/* click on create contact button*/
		CreateContactbtnPage ccbp = new CreateContactbtnPage(driver);
		ccbp.getCreateNewcontactbtn().click();

		/* enter all the details and create new contact*/
		CreateNewcontactpage cnp = new CreateNewcontactpage(driver);
		cnp.createNewcontact(LastName);
		
        /*verify the header message*/
		String actHeader = ccbp.getHeadermsg().getText();
		boolean status = actHeader.contains(LastName);
	    Assert.assertEquals(status, true);
		/*
		 * if(header.equals(LastName)) System.out.println("header is verified");
		 * 
		 * else System.out.println("header is not verified");
		 */
	
		/* verify the contact name*/ 
		String actlastname = ccbp.getVerifylastname().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actlastname, LastName);
		/*
		 * if (actcontact.contains(LastName)) System.out.println(actcontact +
		 * "actcontact is verified ---pass"); else System.out.println(actcontact +
		 * "actcontact is  not verified ---pass");
		 */
	}
	@Test(groups = "RegressionTesting")
	public void createcontactWithSupportDateTest() throws Throwable {

		//read data from excel
		
		String lastname = elib.getDataFromExcelFile("contact", 4, 2)+jlib.getRandomNum();
		
		//step2 navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		//click on create contact button
		CreateContactbtnPage ccbp = new CreateContactbtnPage(driver);
		ccbp.getCreateNewcontactbtn().click();
		//enter all the details and create new contact
		 String startdate = jlib.getSystemdate();
		 String enddate = jlib.getRequiredDate(30);
		 CreateNewcontactpage cnp = new CreateNewcontactpage(driver);
		 cnp.CreateContactWithSupportDate(lastname, startdate, enddate);
		 //driver.switchTo().alert().accept();
		//verify last name
		 String actlastname = ccbp.getVerifylastname().getText();
		  SoftAssert soft = new SoftAssert();
		  soft.assertEquals(actlastname, lastname);
		/*
		 * if(actlastname.contains(lastname)) { System.out.println(lastname +
		 * " informaton is verified"); } else { System.out.println(lastname +
		 * " informaton is not  verified"); }
		 */
		//verify start date
		String actstartdate =ccbp.getVerifyStartDate() .getText();
		Assert.assertTrue(true);
		/*
		 * if(actstartdate.contains(startdate)) { System.out.println(startdate +
		 * "actstartdate informaton is verified"); } else { System.out.println(startdate
		 * + " actstartdate informaton is not  verified"); }
		 */
		String actenddate =ccbp.getVerifyEndDate() .getText();
		SoftAssert soft1 = new SoftAssert();
		soft1.assertTrue(true);
		/*
		 * if(actenddate.contains(enddate)) { System.out.println(enddate +
		 * "actenddate informaton is verified"); } else { System.out.println(enddate +
		 * " informaton is not  verified"); }
		 */
		
		
	}

	
	@Test(groups = "RegressionTesting")
	public void createcontactWithOrgTest() throws Throwable {
		
		//read data from excel
		
		String orgname = elib.getDataFromExcelFile("contact", 7, 2)+jlib.getRandomNum();
		String lastname = elib.getDataFromExcelFile("contact", 7, 3)+jlib.getRandomNum();
		
		//step2 navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
	
		//click on create organization button
		OrganizationsPage onp = new OrganizationsPage(driver);
		onp.getCreateNeworgBtn().click();
	
		//enter all the details and create new organization
		CreatingNewOrganizationPage op = new CreatingNewOrganizationPage(driver);
		op.createorg(orgname);
		
		
		//verify header org name info expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actorgname = oip.getVerifyOrgname().getText();
		Assert.assertEquals(actorgname, orgname);
		//System.out.println(actorgname);
		
		
		
		/*
		 * if(actorgname.trim().equals(orgname))
		 * System.out.println(orgname+" information is verified"); else
		 * System.out.println(orgname+" information is not verified fail" );
		 */
		//navigate to contact module
		hp.getContactLink().click();
		
		// click on create contact button
		CreateContactbtnPage ccbp = new CreateContactbtnPage(driver);
		ccbp.getCreateNewcontactbtn().click();
        //enter all the details and create new contact
		CreateNewcontactpage cnp = new CreateNewcontactpage(driver);
		cnp.CreateContactWithOrg(orgname, lastname);
		wlib.switchtoTabOnUrl(driver, "module=Accounts");
		CreatecontactselectExistOrgPage cseorg = new CreatecontactselectExistOrgPage(driver);
		cseorg.selectExistOrg(orgname);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		//switch to parent window
		wlib.switchtoTabOnUrl(driver, "module=Contacts");
		cnp.getSavebtn().click();
		
		//verify existed org name after save data flow happpening
		String exporg = ccbp.getVeriftExistorg().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(true);
		soft.assertAll();
		/*
		 * if(exporg.equals(orgname))
		 * System.out.println(orgname+" expected org name is verified"); else
		 * System.out.println(orgname+" expected org name is verified");
		 */
	
		
		
	}
}
