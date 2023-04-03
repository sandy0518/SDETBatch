package genericLibrary;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * This method is for maximizing the window
	 * @author saisandeep
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is for implicitwait
	 * @author saisandeep
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method is used to wait till the element visible
	 * @author saisandeep
	 * @param driver
	 * @param ele
	 */
	public void waitForVisibilityofElement(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/**
	 * This method is used to print all the options and count of options
	 * @author saisandeep
	 * @param ele
	 */
	public void getDDOptions(WebElement ele) {
		Select select=new Select(ele);
		List<WebElement> list = select.getOptions();
		int optionsCount=0;
		for(WebElement oList:list) {
			optionsCount++;
			System.out.println(oList.getText());
		}
		System.out.println("The count of options in the DD is "+optionsCount);
	}
	
	/**
	 * This method is used to select option in DD using value
	 * @author saisandeep
	 * @param ele
	 * @param value
	 */
	public void selectbyvalue(WebElement ele,String value) {
		Select select=new Select(ele);
		select.selectByValue(value);
	}
	
	/**
	 * This method is used to select option in DD using index
	 * @author saisandeep
	 * @param ele
	 * @param index
	 */
	public void selectbyIndex(WebElement ele,int index) {
		Select select=new Select(ele);
		select.selectByIndex(index);
	}
	
	/**
	 * This method is used to select option in DD using visibleText
	 * @author saisandeep
	 * @param ele
	 * @param index
	 */
	public void selectbyVisibleText(WebElement ele,String vText) {
		Select select=new Select(ele);
		select.selectByVisibleText(vText);
	}
	
	/**
	 * This method is used to print weather DD is mutiple or not
	 * @author saisandeep
	 * @param ele
	 */
	public void isMultiple(WebElement ele) {
		Select select=new Select(ele);
		select.isMultiple();
	}
	
	/**
	 * This method is used to do mouseover action on element
	 * @author saisandeep
	 * @param driver
	 * @param ele
	 */
	public void mouseOverAction(WebDriver driver, WebElement ele) {
		Actions action=new Actions(driver);
		action.moveToElement(ele).perform();
	}
	
	/**
	 * This method is used to switch window
	 * @author saisandeep
	 * @param driver
	 */
	public void switchWindow(WebDriver driver) {
		Set<String> allHandles = driver.getWindowHandles();
		System.out.println(allHandles);
		for(String ah:allHandles) {
			driver.switchTo().window(ah);
		}
	}
}
