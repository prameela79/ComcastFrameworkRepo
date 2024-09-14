package Pactice.TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createcontact_DP_Test2 {
	@Test(dataProvider = "getData")
	public void createcontactTest(String firstname,String lastname, long phonenum) {
		System.out.println("FirstName: "+ firstname + ", lastName: " + lastname +", phonenum:" + phonenum);
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] objarr = new Object[3][3];
		objarr[0][0] ="deepak";
		objarr[0][1] ="hr";
		objarr[0][2] =478965231l;
		objarr[1][0] ="sam";
		objarr[1][1] ="sh";
		objarr[1][2] = 87459613l;
		objarr[2][0] ="jhon";
		objarr[2][1] ="smith";
		objarr[2][2] = 874596130l;
		return objarr;
		
	}

}
