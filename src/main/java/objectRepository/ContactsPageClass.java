package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPageClass {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement newCon;
	
	public ContactsPageClass (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewCon() {
		return newCon;
	}
	
	public void newContactB() {
		newCon.click();
	}
}
