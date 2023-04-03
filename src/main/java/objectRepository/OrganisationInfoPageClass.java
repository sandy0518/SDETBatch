package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPageClass {
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgaName;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeading;
	
	public OrganisationInfoPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgaName() {
		return orgaName;
	}

	public WebElement getOrgHeading() {
		return orgHeading;
	}
	
//	Bussiness Logic
	
	public void ValidateOrgName() {
		String orgnameText = orgaName.getText();
		String headText = orgHeading.getText();
		if(headText.contains(orgnameText)) {
			System.out.println("Validated Successfully");
		}
	}
}
