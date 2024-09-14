package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactbtnPage {
	WebDriver driver;
   
	public CreateContactbtnPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createNewConBtn;
	
	@FindBy(className = "dvHeaderText")
	private WebElement headermsg;
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement verifylastname;
	
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement verifyStartDate;
	
	@FindBy(id="mouseArea_Support End Date")
	private WebElement verifyEndDate;

	@FindBy(id="mouseArea_Organization Name")
	private WebElement veriftExistorg;
	
	public WebElement getVeriftExistorg() {
		return veriftExistorg;
	}

	public WebElement getVerifyStartDate() {
		return verifyStartDate;
	}

	public WebElement getVerifyEndDate() {
		return verifyEndDate;
	}

	public WebElement getCreateNewcontactbtn() {
		return createNewConBtn;
	}
	
	public WebElement getHeadermsg() {
		return headermsg;
	}

	public WebElement getVerifylastname() {
		return verifylastname;
	}
	
	
	

}
