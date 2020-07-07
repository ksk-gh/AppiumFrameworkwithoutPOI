package practice.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataForEditField()
	{
		
		
		Object[][] obj = new Object[][]
				{
			{"Hello"},{"@#$"}
				};
		
		return obj;
	}
	
	
}
