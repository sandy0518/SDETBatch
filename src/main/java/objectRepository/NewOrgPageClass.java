package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.WebDriverUtility;

public class NewOrgPageClass {

	 WebDriverUtility wdu=new WebDriverUtility();
	
	@FindBy(name = "accountname")
	private WebElement orgName;

	@FindBy(name = "industry")
	private WebElement indDD;

	@FindBy(name = "button")
	private WebElement saveButton;

	public NewOrgPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndDD() {
		return indDD;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	//Bussiness Logic

	public void organizationName(String value) {
		orgName.sendKeys(value);   
	}

	public void industryDD(String industryType) {
		wdu.isMultiple(indDD);
		wdu.selectbyvalue(indDD, industryType);
	}

	public void saveButon() {
		saveButton.click();
	}
}
