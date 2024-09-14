package Pactice.TestNg;

import org.testng.annotations.Test;

public class OrderTest {
	@Test(invocationCount = 10)
	public void CreateorderTest() {
		System.out.println("Execute create order test--->123");
		
	}
	@Test(dependsOnMethods="CreateorderTest")
	public void billingAnorderTest() {
		System.out.println("Execute billing an ordertest---->123");
	}

}
