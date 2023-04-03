package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConInfoPageClass {
	
	@FindBy(id = "dtlview_First Name")
	private WebElement confName;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement conHeading;
	
	public ConInfoPageClass(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getConfName() {
		return confName;
	}

	public WebElement getConHeading() {
		return conHeading;
	}
	
	public void validateContact(){
		String conFN = confName.getText();
		String conHeadingg = conHeading.getText();
		if(conHeadingg.contains(conFN)) {
			System.out.println("validated successfully");
		}
	}
}
