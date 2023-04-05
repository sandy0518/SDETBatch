package com.crm.VTiger.TestCases;

import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.JavaUtility;
import objectRepository.HomePageClass;
import objectRepository.NewOrgPageClass;
import objectRepository.OrganisationsPageClass;

@Listeners(genericLibrary.ListenerImplementation.class)
public class CreateAndDeleteAnOrganisationTest extends BaseClass{
	@Test (groups = "smoke")
	public void createAndDeleteAnOrganisationTest() throws Throwable {
		String orgName = efu.readDataFromExcel("sheet1", 1, 1)+JavaUtility.randomNumber();

		HomePageClass hpc=new HomePageClass(driver);
		hpc.organizationButton();

		OrganisationsPageClass opc=new OrganisationsPageClass(driver);
		opc.newOrgButton();
		NewOrgPageClass npc=new NewOrgPageClass(driver);
		npc.organizationName(orgName);
//		fail();
		npc.saveButon();		
		Thread.sleep(3000);

		hpc.organizationButton();

		opc.checkButton();
		opc.deleteOrg();

		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}
}
