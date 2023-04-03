package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;

public class PrintingAllLinktextPresentonWebPage extends BaseClass{
	@Test
	public void printingAllLinktextPresentonWebPage() {
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int size = allLinks.size();
		System.out.println("The size is "+size);
		for(int i=0;i<size;i++) {
			System.out.println(allLinks.get(i).getText());
		}
	}

}
