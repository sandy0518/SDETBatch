package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.WebDriverUtility;

public class NewConPageClass {
	
	WebDriverUtility wdu=new WebDriverUtility();
	
	@FindBy(name = "salutationtype")
	private WebElement fNameDD;
	
	@FindBy(name = "firstname")
	private WebElement fNameTF;
	
	@FindBy(name = "lastname")
	private WebElement lNameTF; 
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")  
	private WebElement addOrgNameButton;  
	
	@FindBy(name = "button")  
	private WebElement saveButton;
	
	public NewConPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getfNameDD() {
		return fNameDD;
	}

	public WebElement getfNameTF() {
		return fNameTF;
	}

	public WebElement getlNameTF() {
		return lNameTF;
	}

	public WebElement getAddOrgNameButton() {
		return addOrgNameButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void firstNameDD(String firstNameType) {
		wdu.isMultiple(fNameDD);
		wdu.getDDOptions(fNameDD);
		wdu.selectbyvalue(fNameDD, firstNameType);
	}
	
	public void fandLName(String value1, String value2) {
		fNameTF.sendKeys(value1);
		lNameTF.sendKeys(value2);
	}
	
	public void addOrgButton() {
		addOrgNameButton.click();
	}
	
	public void saveButtonn() {
		saveButton.click();
	}
}
