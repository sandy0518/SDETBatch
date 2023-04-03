package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import objectRepository.AddOrgPageClass;
import objectRepository.ContactsPageClass;
import objectRepository.HomePageClass;
import objectRepository.NewConPageClass;

public class CreateContactWithOrganisationTest extends BaseClass{
	@Test (groups = "regression")
	public void createContactWithOrganisationTest() throws Throwable {
		
//		Getting Test data from ExcelFileUtility
		String fName = efu.readDataFromExcel("sheet1", 7, 1);
		String sName = efu.readDataFromExcel("sheet1", 7, 2);
		String fNameType = efu.readDataFromExcel("sheet1", 7, 3);

		HomePageClass hpc=new HomePageClass(driver);
		hpc.contactButton();

		ContactsPageClass cpc=new ContactsPageClass(driver);
		cpc.newContactB();

		NewConPageClass ncpc=new NewConPageClass(driver);
		ncpc.firstNameDD(fNameType);
		ncpc.fandLName(fName, sName);
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
	}
}
