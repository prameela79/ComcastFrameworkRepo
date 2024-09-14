package Pactice.TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;

public class config_annotation extends BaseClass {
	
	@Test
	public void createcontact() {
		System.out.println("execte create contact");
	}
	

	@Test
	public void createcontactwithdate() {
		System.out.println("execte create contact with date");
	}
	
}
