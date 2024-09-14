package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\commondata.properties");
		//step2:using property class load all the keys
        Properties p = new	Properties();
        p.load(fis);
	    String BROWSER = p.getProperty("browser");
	    String URL= p.getProperty("url");
	    String USERNAME = p.getProperty("username");
	    String PASSWORD = p.getProperty("password");
	    
	    WebDriver driver = null;
	    if(BROWSER.equals("chrome"))
	    	driver =  new ChromeDriver();
	    else if(BROWSER.equals("edge"))
	    	driver =  new EdgeDriver();
	    else if(BROWSER.equals("firefox"))
	    	driver =  new FirefoxDriver();
	    else 
	    	driver =  new ChromeDriver();
	    
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		//step1 : login
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//step2: navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		//step3: click on create organization button
		driver.findElement(By.xpath(""));
		driver.quit();
		

	}

}
