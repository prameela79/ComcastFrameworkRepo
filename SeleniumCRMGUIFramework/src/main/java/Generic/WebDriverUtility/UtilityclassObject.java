package Generic.WebDriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityclassObject {
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	//provide getter method for extent test
	public static ExtentTest getTest() {
		return test.get();
	}
	
	//provide set method for extent test
	public static void setTest(ExtentTest acttest) {
		test.set(acttest);
	}
	//provide getter method for extent test
		public static WebDriver getDriver() {
			return driver.get();
		}
		
		//provide set method for extent test
		public static void setDriver(WebDriver actdriver) {
			driver.set(actdriver);
		}
	

}
