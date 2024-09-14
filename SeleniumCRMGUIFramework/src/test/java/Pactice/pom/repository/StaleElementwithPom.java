package Pactice.pom.repository;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class StaleElementwithPom {

		@FindBy(name="user_name")
		WebElement ele1;
		
		@FindBy(name="user_password")
		WebElement ele2;
		@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@vale='Login']")})
		private WebElement ele3;
		@Test
		public void staleelement() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		StaleElementwithPom s = PageFactory.initElements(driver, StaleElementwithPom.class);
		driver.navigate().refresh();
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		s.ele3.click();
		driver.quit();
		
		

	}

}
