package sampleScripts;

import org.testng.annotations.Test;

import genericLibrary.BaseClass;

public class SampleScript1 extends BaseClass{
	@Test(priority = 1, invocationCount = 4)
	public void createss1() {
		System.out.println("sample script 1");
	}
	@Test(priority = 2)
	public void modifyss2() {
		System.out.println("sample script 2");
	}
	@Test(priority = 3)
	public void deletess3() {
		System.out.println("sample script 3");
	}
}
