package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatecontactselectExistOrgPage {
	WebDriver driver;
	public CreatecontactselectExistOrgPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement serchText;
	
	@FindBy(name="search")
	private WebElement serchBtn;
	
	@FindBy(name="search_field")
	private WebElement searchfiedEdt;
	public WebElement getSerchText() {
		return serchText;
	}

	public WebElement getSerchBtn() {
		return serchBtn;
	}

	public WebElement getSearchfiedEdt() {
		return searchfiedEdt;
	}
	
	public void selectExistOrg(String Orgname) {
		getSerchText().sendKeys(Orgname);
		getSerchBtn().click();
	}
	

}
