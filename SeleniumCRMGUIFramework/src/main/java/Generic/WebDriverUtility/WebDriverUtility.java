package Generic.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void WaitForPageToload(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitforElementPresent(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
//switch to new browser tab based on url
	public void switchtoTabOnUrl(WebDriver driver, String partialurl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String windId = itr.next();
			driver.switchTo().window(windId);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains(partialurl))
				break;
		}
	}
	
	//switch to new browser tab based on title
		public void switchtotabOntitle(WebDriver driver, String title) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> itr = set.iterator();
			while(itr.hasNext()) {
				String windId = itr.next();
				driver.switchTo().window(windId);
				String acttitle = driver.getCurrentUrl();
				if(acttitle.contains(title))
					break;
			}
		}
		
    //select the value from drop down based on visibility text
		public void select(WebElement element, String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		
	//select the value from drop down based on index
		public void select(WebElement element, int index) {
			Select sel = new Select(element);
		    sel.selectByIndex(index);
			}
				
	//select the value from drop down based on index
		public void select(String value, WebElement element) {
			Select sel = new Select(element);
			sel.selectByValue(value);;
		
}
}
