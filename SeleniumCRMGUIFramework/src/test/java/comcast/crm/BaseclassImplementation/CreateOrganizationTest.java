package comcast.crm.BaseclassImplementation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ListenerUtility.listimpclass;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.baseTest.BaseClass2;

import Generic.WebDriverUtility.UtilityclassObject;
import ObjectRepositoryUtility.CreatingNewOrganizationPage;
import ObjectRepositoryUtility.HomePage;
import ObjectRepositoryUtility.OrganizationInfoPage;
import ObjectRepositoryUtility.OrganizationsPage;
@Listeners(com.comcast.crm.ListenerUtility.listimpclass.class)
public class CreateOrganizationTest extends BaseClass {
	@Test(groups = "smokeTesting")
	public void createOrgtest() throws Throwable {
		// read data from excel
		//listimpclass.test.log(Status.INFO, "read data from excel");
		UtilityclassObject.getTest().log(Status.INFO, "read data from excel");
		String orgname = elib.getDataFromExcelFile("org", 1, 2) + jlib.getRandomNum();

		// step2 navigate organization module
		//listimpclass.test.log(Status.INFO, "navigate to org page");
		UtilityclassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create organization button
		//listimpclass.test.log(Status.INFO, "navigate to create org page");
		UtilityclassObject.getTest().log(Status.INFO, "navigate to create org page");
		OrganizationsPage og = new OrganizationsPage(driver);
		og.getCreateNeworgBtn().click();

		// enter all the details and create new organization
		listimpclass.test.log(Status.INFO, "create a new org");
		UtilityclassObject.getTest().log(Status.INFO, "create a new org");
		CreatingNewOrganizationPage op = new CreatingNewOrganizationPage(driver);
		op.createorg(orgname);
		UtilityclassObject.getTest().log(Status.PASS, orgname+"====>create a new org");

		// verify header msg expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actheader = oip.getHeadermsg().getText();
		boolean status = actheader.contains(orgname);
		Assert.assertEquals(status, true);
	 
		//verify the orgname
		String actorgName = oip.getVerifyOrgname().getText();
		Assert.assertEquals(actorgName, orgname);
		/*
		 * if (actorgName.contains(orgname)) System.out.println("orgname is verified");
		 * else System.out.println("orgname is not verified");
		 */

	}

	@Test(groups = "RegresiionTesting")
	public void createOrgWithIndustrytest() throws Throwable {
		// read data from excel

		String orgname = elib.getDataFromExcelFile("org", 4, 2) + jlib.getRandomNum();
		String industry = elib.getDataFromExcelFile("org", 4, 3);
		String type = elib.getDataFromExcelFile("org", 4, 4);

		// step2 navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
        // click on create new org button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNeworgBtn().click();
		// enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname, industry);
		cnop.CreateOrg(orgname, type);

		// verify the industries and type info
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actindustry = oip.getVerifyindustry().getText();
		Assert.assertEquals(actindustry, industry);
		/*
		 * if (actindustry.contains(industry)) System.out.println(actindustry +
		 * "industry info is verified"); else System.out.println(orgname +
		 * "industry info is not verified");
		 */
		// verify type info
		
		String acttype = oip.getVerifyType().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(acttype, type);
		soft.assertAll();
		/*
		 * if (acttype.contains(type)) System.out.println(orgname +
		 * " type info is verified"); else System.out.println(orgname +
		 * " type info is not verified fail");
		 */
		
	}

	@Test(groups = "RegressionTesting")
	public void createOrgWithphonenumber() throws Throwable {

		// read data from excel
		String orgname = elib.getDataFromExcelFile("org", 7, 2) + jlib.getRandomNum();
		String phonenum = elib.getDataFromExcelFile("org", 7, 3);

		// step2 navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// click on create new organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNeworgBtn().click();
		// enter all the details and create new organization
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createorg(orgname);
		cop.getPhonenum().sendKeys(phonenum);
		// verify the header phone number info expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actphonenum = oip.getVerifyphone().getText();
		Assert.assertEquals(actphonenum, phonenum);
		/*
		 * if (actphonenum.contains(phonenum)) System.out.println(actphonenum +
		 * "actphonenum info is verified"); else System.out.println(actphonenum +
		 * "actphonenum info is not verified");
		 */
	
	}
}
