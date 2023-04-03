package genericLibrary;

import java.util.Random;

public class JavaUtility {
	
	/**
	 * @author saisandeep
	 * @return
	 */

	public static int randomNumber() {
		Random r=new Random();
		int ranNumber = r.nextInt(1000);
		return	ranNumber;
	}
}
