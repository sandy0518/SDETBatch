package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//	Rule-1 Create seperate class for each webPage
public class LoginPageClass {
//	Rule-2 Store locators using anotations
	@FindBy(name="user_name")
	private WebElement usNameTF;
	
	@FindBy(name="user_password")
	private WebElement pwdTF;
	
	@FindBy(id="submitbutton")
	private WebElement loginButton;
	
//	Rule-3 Create constructor to initialize the object
	public LoginPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	Rule-4 Create getters for all the attributes
	public WebElement getUsNameTF() {
		return usNameTF;
	}

	public WebElement getPwdTF() {
		return pwdTF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
//	Rule-5 Create business logic method
	/** 
	 * @author saisandeep
	 * @param name
	 * @param Password
	 */
	public void login(String username, String password) {
		usNameTF.sendKeys(username);
		pwdTF.sendKeys(password);
		loginButton.click();
	}
}
