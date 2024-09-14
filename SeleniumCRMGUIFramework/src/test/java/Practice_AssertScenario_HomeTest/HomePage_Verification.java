package Practice_AssertScenario_HomeTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage_Verification {
 @Test 
 public void homepageTest(Method mtd) {
	 System.out.println(mtd.getName() + "Test Start");
	 String expectedpage = "Home page";
	 WebDriver driver =new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.get("http://localhost:8888/");
	 driver.findElement(By.name("user_name")).sendKeys("admin");
	 driver.findElement(By.name("user_password")).sendKeys("admin");
	 driver.findElement(By.id("submitButton")).click();
	 String hometest = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		/*
		 * if(hometest.trim().equals(expectedpage)) {
		 * System.out.println("Expected page is verified"); } else {
		 * System.out.println("Expected page is not verified"); }
		 */
	 // Hard Assert
	 Assert.assertEquals(hometest, expectedpage);
	 System.out.println(mtd.getName() + "Test End");
	 
 }
 @Test
 public void verifylogohomepageTest(Method mtd) {
	 System.out.println(mtd.getName() + "Test Start");
	 WebDriver driver =new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.get("http://localhost:8888/");
	 driver.findElement(By.name("user_name")).sendKeys("admin");
	 driver.findElement(By.name("user_password")).sendKeys("admin");
	 driver.findElement(By.id("submitButton")).click();
	 boolean status = driver.findElement(By.xpath("//img[@src=\"test/logo/vtiger-crm-logo.gif\"]")).isEnabled();
		/*
		 * if(status) { System.out.println("Logo is verified"); } else {
		 * System.out.println("Logo is not verified"); }
		 */
	 //Assert.assertEquals(true, status);
	// Hard Assert
	 Assert.assertTrue(status);
	 driver.close();
	 System.out.println(mtd.getName() + "Test End");
	 
 }

}

