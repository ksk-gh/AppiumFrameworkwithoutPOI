package practice.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.Dependencies;
import pageobjects.HomePage;
import pageobjects.Preferences;

public class ApiDemoTest extends EcommerceBase {

	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void apiDemoTest(String input) throws IOException {
		// TODO Auto-generated method stub
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("apidemo");

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		HomePage h = new HomePage(driver);
		
		// driver.findElementByXPath("//android.widget.TextView[@content-desc='Preference']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		h.preferences.click();
		
		Preferences p =new Preferences(driver);
		
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		p.dependencies.click();
		
		Dependencies d = new Dependencies(driver);
		
		
//		System.out.println("Checkbox is in enabeld "+d.wifiCheckbox.isSelected() +" state");
		//d.preferdependencies.click();
		d.wifiCheckbox.click();
		
		
		driver.hideKeyboard();
		d.wifiSettings.click();
		driver.hideKeyboard();
		d.wifiEditBox.sendKeys(input);

		d.okButton.get(1).click();
		//d.okButton.get(1).click();
		driver.closeApp();
		service.stop();

		//driver.close();*/
	}
	
	
	

}
