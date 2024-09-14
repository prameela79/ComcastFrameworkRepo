package Pactice.TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	public void configBS() {
		System.out.println("-----connect to db,report config-----");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("--launch browser----");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("----close browser---");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("----close db,report backup---");
	}
	
	@BeforeMethod
	public void configbm() {
		System.out.println("--login to application---");
	}
	
	@AfterMethod
	public void configam() {
		System.out.println("---logout-----");
	}
	
	

}
