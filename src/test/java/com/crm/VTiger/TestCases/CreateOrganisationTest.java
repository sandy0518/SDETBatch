package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.JavaUtility;
import objectRepository.HomePageClass;
import objectRepository.NewOrgPageClass;
import objectRepository.OrganisationsPageClass;

public class CreateOrganisationTest extends BaseClass{
	@Test (groups = "smoke")
	public void createOrganisationTest() throws Throwable {

		String orgName = efu.readDataFromExcel("sheet1", 1, 1)+JavaUtility.randomNumber();

		HomePageClass hpc=new HomePageClass(driver);
		hpc.organizationButton();

		OrganisationsPageClass opc=new OrganisationsPageClass(driver);
		opc.newOrgButton();

		NewOrgPageClass npc = new NewOrgPageClass(driver);
		npc.organizationName(orgName);
		npc.saveButon();

		Thread.sleep(3000);		
	}
}
