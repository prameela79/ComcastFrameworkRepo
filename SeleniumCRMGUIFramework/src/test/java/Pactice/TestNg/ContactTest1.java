package Pactice.TestNg;

import org.testng.annotations.Test;

public class ContactTest1 {
	@Test
	public void createcontact() {
		System.out.println("execute create contact with--->HDFC");
	}
	@Test(dependsOnMethods="createcontact")
	public void modifycontact() {
		System.out.println("execute modify contact with-->HDFC--->ICICI");
	}
	@Test(dependsOnMethods="modifycontact")
	public void deletecontact() {
		System.out.println("execute delete contact test ICICI");
	}

}
