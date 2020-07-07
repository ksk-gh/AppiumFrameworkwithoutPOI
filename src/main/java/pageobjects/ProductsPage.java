package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {

	
	public ProductsPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	//	PageFactory.initElements(driver, this);
	}

	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	private List<WebElement> addToCartButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartIcon;
	
	
	
	public List<WebElement> addCart()
	{

		return addToCartButton;
	}
	
	
	
	public WebElement cartButton()
	{
		return cartIcon;
	}

	
	
}
