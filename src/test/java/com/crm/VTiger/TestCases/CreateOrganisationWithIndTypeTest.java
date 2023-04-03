package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.JavaUtility;
import objectRepository.HomePageClass;
import objectRepository.NewOrgPageClass;
import objectRepository.OrganisationsPageClass;

public class CreateOrganisationWithIndTypeTest extends BaseClass{
	@Test
	public void createOrganisationWithIndTypeTest() throws Throwable {

		String orgName = efu.readDataFromExcel("sheet1", 1, 1)+JavaUtility.randomNumber();
		String indTypevalue = efu.readDataFromExcel("sheet1", 4, 2);

		HomePageClass hpc=new HomePageClass(driver);
		hpc.organizationButton();
		
		OrganisationsPageClass opc=new OrganisationsPageClass(driver);
		opc.newOrgButton();
		
		NewOrgPageClass nopc=new NewOrgPageClass(driver);
		nopc.organizationName(orgName);
		nopc.saveButon();
		nopc.industryDD(indTypevalue);
		nopc.saveButon();
	}
}
