package testAnnotations;

import org.testng.annotations.Test;

public class PassParameter {
	@Test
	public void runParameterTest() {
		String Browser = System.getProperty("browser");
		System.out.println(Browser);
	}
}
