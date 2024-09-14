package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;
/**
 * @author prameela
 * contain login page elements & business library like login
 */
public class LoginPage extends WebDriverUtility{ //rule-1 Create a separate class
	                     //rule-2 object creation means identify all the elements using @fingby
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	//rule-4 object encapsulation
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	              
	//rule-3 object Initialization go to script
	
	//step 5 provide Action
	/**
	 * login to application based on username ,password, url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	public void logintoapp(String url, String username, String password) {
		WaitForPageToload(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdit.sendKeys("admin");
		passwordEdit.sendKeys("admin");
		loginBtn.click();
		
	}
}
