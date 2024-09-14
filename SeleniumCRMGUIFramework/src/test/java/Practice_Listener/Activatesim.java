package Practice_Listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;

//@Listeners(com.comcast.crm.ListenerUtility.listimpclass.class)
public class Activatesim extends BaseClass {
	@Test(retryAnalyzer=com.comcast.crm.ListenerUtility.RetryListenerimp.class)
	public void activatesim() {
		System.out.println("execute createInvoiceTest ");
		//String title = driver.getTitle();
		Assert.assertEquals("","Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
