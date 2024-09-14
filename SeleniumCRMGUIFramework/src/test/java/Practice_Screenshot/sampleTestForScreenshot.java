package Practice_Screenshot;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;

public class sampleTestForScreenshot  {
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.in");
		
		//step1 convert driver cast type into takescreenshot type by using(downcast)
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		//step2 use getscreensotAs method
		File term = ts.getScreenshotAs(OutputType.FILE);//it return screenshot store in file class
		
		//copy the screen shot in or required path
		File perm = new File("./Screenshot/amazon.png");
		
		//copy the source file to destination file
		FileHandler.copy(term, perm);
		driver.close(); 
	}	
}

