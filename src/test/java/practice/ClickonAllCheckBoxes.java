package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import objectRepository.HomePageClass;

public class ClickonAllCheckBoxes extends BaseClass{
	@Test
	public void clickonAllCheckBoxes() {
		HomePageClass hpc=new HomePageClass(driver);
		hpc.organizationButton();
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int cBSize = checkBoxes.size();
		System.out.println(cBSize);
//		Click on all the CheckBoxes in forward Order
//		for(int i=1;i<cBSize;i++) {
//			checkBoxes.get(i).click();
//		}
		
//		Click on all the CheckBoxes in reverse Order
		for(int i=cBSize-1;i>0;i--) {
			checkBoxes.get(i).click();
		}
	}
}
