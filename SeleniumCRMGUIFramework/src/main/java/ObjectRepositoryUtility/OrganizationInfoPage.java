package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement headermsg;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement verifyOrgname;
	
	public WebElement getVerifyOrgname() {
		return verifyOrgname;
	}

	public WebElement getVerifyindustry() {
		return verifyindustry;
	}

	public WebElement getVerifyType() {
		return verifyType;
	}

	public WebElement getVerifyphone() {
		return verifyphone;
	}
	@FindBy(id="dtlview_Industry")
	private WebElement verifyindustry;
	
	@FindBy(id="dtlview_Type")
	private WebElement verifyType;
	
	@FindBy(id="dtlview_Phone")
	private WebElement verifyphone;
	
	public WebElement getHeadermsg() {
		return headermsg;
	}
	
	

}
