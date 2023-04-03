package sampleScripts;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;

public class ReTryAnaEx extends BaseClass{
	@Test(retryAnalyzer = genericLibrary.RetryAnalyzerImplementation.class)
	public void step1() {
		System.out.println("Run for 1 time");
		fail();
	}
}
