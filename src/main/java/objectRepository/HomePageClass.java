package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.WebDriverUtility;

public class HomePageClass {
	
	WebDriverUtility wdu=new WebDriverUtility();
	
	@FindBy(linkText = "Organizations")
	private WebElement orgButton;
	
	@FindBy(linkText = "Contacts")
	private WebElement conButton;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutButton;
	
	public HomePageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgButton() {
		return orgButton;
	}

	public WebElement getConButton() {
		return conButton;
	}

	public WebElement getAdmImg() {
		return admImg;
	}

	public WebElement getSignOutButton() {
		return signOutButton;
	}
	
	public void organizationButton() {
		orgButton.click();
	}
	public void contactButton() {
		conButton.click();
	}
	public void logOut(WebDriver driver) throws Throwable {
		wdu.mouseOverAction(driver, admImg);
		signOutButton.click();
	}
}
