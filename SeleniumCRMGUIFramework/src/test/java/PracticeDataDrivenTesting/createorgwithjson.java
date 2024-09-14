package PracticeDataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class createorgwithjson {
	@Test
	public void readdatacmd() throws Throwable, ParseException {
	//read data from json
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(new FileReader("C:\\Users\\HP\\Desktop\\commdata\\appcommondata.json"));
		
	JSONObject  map = (JSONObject)obj;
	String BROWSER = map.get("browser").toString();
	String URL= map.get("url").toString();
	String USERNAME = map.get("username").toString();
	String PASSWORD = map.get("password").toString();
    
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
