package Pactice.TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.FileUtilities.ExcelUtility;

public class GetproductIntoTest_DP_Realtime {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandname, String productname) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		
		//capture product info
	    String price = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\" and contains(.,'"+productname+"')]/descendant::span[@class=\"a-price-whole\"]")).getText();
	    System.out.println(price);
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		int rowcount = elib.getRowCount("product");
		Object[][] objarr = new Object[rowcount][2];
		for(int i=0;i<rowcount;i++) {
		objarr[i][0] = elib.getDataFromExcelFile("product", i+1, 0) ;
		objarr[i][1] =elib.getDataFromExcelFile("product", i+1, 1) ;
		
		}
		return objarr;
		
	}

}
