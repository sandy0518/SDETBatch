package com.crm.VTiger.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import objectRepository.AddOrgPageClass;
import objectRepository.ContactsPageClass;
import objectRepository.HomePageClass;
import objectRepository.NewConPageClass;

public class ValidateContactNameTest extends BaseClass{
	@Test (groups = "regression")
	public void validateContactNameTest() throws Throwable {
//		Getting testdata from ExcelFileUtility
		String firstName = efu.readDataFromExcel("sheet1", 7, 1);
		String lastName = efu.readDataFromExcel("sheet1", 7, 2);
		String fNTValue = efu.readDataFromExcel("sheet1", 7, 3);

		HomePageClass hpc=new HomePageClass(driver);
		hpc.contactButton();
		
		ContactsPageClass cpc=new ContactsPageClass(driver);
		cpc.newContactB();
		
		NewConPageClass ncpc=new NewConPageClass(driver);
		ncpc.firstNameDD(fNTValue);
		ncpc.fandLName(firstName, lastName);
		ncpc.addOrgButton();
		String parentWind = driver.getWindowHandle();
		
		wdu.switchWindow(driver);
		AddOrgPageClass apc=new AddOrgPageClass(driver);
		apc.searchTextField();
		apc.searchB();
		apc.selectOrganisation();
		
		driver.switchTo().window(parentWind);
		
		ncpc.saveButtonn();
		Thread.sleep(3000);
		
		WebElement actualHeading = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String aH = actualHeading.getText();
		if(aH.contains(firstName)) {
			System.out.println("validated successfully");
		}
		else {
			System.out.println("Not validated");
		}
	}
}
