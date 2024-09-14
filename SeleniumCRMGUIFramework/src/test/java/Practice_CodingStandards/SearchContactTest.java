package Practice_CodingStandards;

import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;

import ObjectRepositoryUtility.LoginPage;

/**
 * test class for contact module
 * @author prameela
 */
public class SearchContactTest extends BaseClass {
	/**
	 * Scenario: login()===>navigatecontact====>createcontact()===verify
	 */
	
	@Test
	public void seractContactTest() {
		/*step-1 login to app*/
		LoginPage lp = new LoginPage(driver);
		lp.logintoapp("url", "username", "password");
		
		
		
		
	}

}
