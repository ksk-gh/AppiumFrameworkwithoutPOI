package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private  WebElement nameField;
	
	//android.widget.RadioButton[@text='Female']
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	//"android:id/text1"
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;

	//com.androidsample.generalstore:id/btnLetsShop
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButton;
	
	public WebElement getNameField()
	{
		System.out.println("Trying to find the name field");
		return nameField;
	}
	
	
	public WebElement getFemaleOption()
	{
		return femaleOption;
	}
	
	public WebElement getcountrySelection()
	{
		System.out.println("Selecting the country from the dropdown");
		return countrySelection;
	}
	
	
	public WebElement getLetsShopButton()
	{
		return letsShopButton;
	}
	
	

}




