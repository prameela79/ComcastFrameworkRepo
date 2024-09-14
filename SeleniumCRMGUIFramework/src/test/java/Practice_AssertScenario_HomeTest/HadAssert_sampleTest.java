package Practice_AssertScenario_HomeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;  

public class HadAssert_sampleTest {
	@Test
	public void hardassert() {
		SoftAssert obj = new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		obj.assertEquals("Home", "Home-page");
		System.out.println("step-3");
		Assert.assertEquals("Home-CRM", "Home-CRM");
		System.out.println("step-4");
		obj.assertAll();
	}

	@Test
	public void hardassert1() {
		SoftAssert obj1 = new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		obj1.assertTrue(true);
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
