package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOrgPageClass {
	
	@FindBy(name = "search_text")
	private WebElement searchTF;
	
	@FindBy(xpath = "//input[@type='button']")
	private WebElement searchButton;
	
	@FindBy(linkText = "RMG653")
	private WebElement selectOrg;
	
	public AddOrgPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSelectOrg() {
		return selectOrg;
	}
	
	public void searchTextField() throws Throwable {
		searchTF.sendKeys("RMG653");
		Thread.sleep(3000);
	}
	
	public void searchB() {
		searchButton.click();
	}
	
	public void selectOrganisation() {
		selectOrg.click();
	}
}
