package PracticeDataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class createorgreaddatacmd {
	@Test
	public void readdatacmd() {
	//read data from cmd
	String BROWSER = System.getProperty("browser");
    String URL= System.getProperty("url");
    String USERNAME = System.getProperty("username");
    String PASSWORD = System.getProperty("password");
    
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
	driver.quit();

}

}
