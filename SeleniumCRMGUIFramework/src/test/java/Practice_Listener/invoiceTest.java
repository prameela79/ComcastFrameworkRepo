package Practice_Listener;

import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;

// @Listeners(com.comcast.crm.ListenerUtility.listimpclass.class)
public class invoiceTest extends BaseClass {
	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest ");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3"); 
		
		System.out.println("step-4");
	}

	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute createInvoiceWithContactTest ");
	    System.out.println("step-1");
	    System.out.println("step-2");
	    System.out.println("step-3");
	    System.out.println("step-4");
	 	
	}
}
