package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import genericLibrary.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAutoSuggession {
	
	@Test
	public void handlingAutoSuggession() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(co);
		driver.get("https://www.google.com/");
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.maximizeWindow(driver);
		wdu.waitForPageLoad(driver);
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("rana");
		List<WebElement> autoSuggessions = driver.findElements(By.xpath("//span[contains(text(),'rana')]"));
		int aSSize = autoSuggessions.size();
		System.out.println(aSSize);
		for(int i=0;i<aSSize;i++) {
			System.out.println(autoSuggessions.get(i).getText());
			if(autoSuggessions.get(i).getText().contains("telugu ott")) {
				autoSuggessions.get(i).click();
			}
		}
		driver.close();
	}
}
