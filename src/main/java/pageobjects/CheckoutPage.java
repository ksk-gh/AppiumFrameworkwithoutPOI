package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {

	public CheckoutPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	//	PageFactory.initElements(driver, this);
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	//com.androidsample.generalstore:id/totalAmountLbl
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmountLabel;
	
	
	
	public List<WebElement> listOfProducts()
	{
		return productList;
	}
	
	
	public WebElement totalAmount()
	{
		return totalAmountLabel;
	}
	
}


