package testAnnotations;

import org.testng.annotations.Test;

import genericLibrary.BaseClass;

public class InvocationCountt extends BaseClass{
	@Test
	public void creOrg() {
		System.out.println("Create Organisation");
	}
	
	@Test(invocationCount = 3)
	public void creConwithOrg() {
		System.out.println("Create Contact With Organisation");
	}
	
	@Test
	public void creCon() {
		System.out.println("Create Contact");
	}
}
