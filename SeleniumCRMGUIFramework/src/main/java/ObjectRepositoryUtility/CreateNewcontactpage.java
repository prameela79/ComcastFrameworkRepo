
package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewcontactpage {
	WebDriver driver;
	public CreateNewcontactpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	private WebElement LastNameEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	@FindBy(name = "support_start_date")
	private WebElement StartDate;
	
	@FindBy(name = "support_end_date")
	private WebElement EndDate;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement orgBtn;
	
	public WebElement getStartDate() {
		return StartDate;
	}

	public WebElement getEndDate() {
		return EndDate;
	}

	public WebElement getCreatecontact() {
		return LastNameEdit;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createNewcontact(String lastName) {
		LastNameEdit.sendKeys(lastName);
		savebtn.click();
	}
	
	public void CreateContactWithSupportDate(String lastName, String StartDate, String EndDate) {
		getLastNameEdit().sendKeys(lastName);
		getStartDate().sendKeys(StartDate);
		getEndDate().clear();
		getEndDate().sendKeys(EndDate);
		getSavebtn().click();	
	}
	public void CreateContactWithOrg(String orgname, String lastName) {
		getLastNameEdit().sendKeys(lastName);
		getOrgBtn().click(); 
	}

	public WebElement getLastNameEdit() {
		return LastNameEdit;
	}

	public WebElement getOrgBtn() {
		return orgBtn;
	}
}
