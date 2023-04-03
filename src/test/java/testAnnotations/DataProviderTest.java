package testAnnotations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;

public class DataProviderTest extends BaseClass{
	
	@Test(dataProvider = "provideMeData")
	public void getMultipleData(String name, int id) {
		System.out.println("The name is "+name+" and id is "+id);
	}
	
	@DataProvider
	public Object[][] provideMeData(){
		Object [][] obj=new Object[4][2];
		obj[0][0]="sandeep";
		obj[0][1]=101;
		
		obj[1][0]="sandy";
		obj[1][1]=102;

		obj[2][0]="sandya";
		obj[2][1]=103;
		
		obj[3][0]="sanjaya";
		obj[3][1]=104;
		
		return obj;
	}
}
