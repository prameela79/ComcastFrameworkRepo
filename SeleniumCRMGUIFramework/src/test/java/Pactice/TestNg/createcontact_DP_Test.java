package Pactice.TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createcontact_DP_Test {
	@Test(dataProvider = "getData")
	public void createcontactTest(String firstname,String lastname) {
		System.out.println("FirstName: "+ firstname +"lastName: "+ lastname);
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] objarr = new Object[3][2];
		objarr[0][0] ="deepak";
		objarr[0][1] ="hr";
		objarr[1][0] ="sam";
		objarr[1][1] ="sh";
		objarr[2][0] ="jhon";
		objarr[2][1] ="smith";
		return objarr;
		
	}

}
