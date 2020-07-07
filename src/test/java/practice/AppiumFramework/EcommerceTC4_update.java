package practice.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.CheckoutPage;
import pageobjects.FormPage;
import pageobjects.ProductsPage;

public class EcommerceTC4_update extends EcommerceBase {

	@Test
	public void totalValidation() throws IOException, InterruptedException {
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		FormPage f = new FormPage(driver);

		// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		f.getNameField().sendKeys("Hello");
		driver.hideKeyboard();
		// driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		f.getFemaleOption().click();

		// driver.findElement(By.id("android:id/text1")).click();
		f.getcountrySelection().click();

		Utilities u = new Utilities(driver);

		/*
		 * driver.findElementByAndroidUIAutomator(
		 * "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"
		 * );
		 */
		u.scrollToText("Argentina");

		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		// driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		f.getLetsShopButton().click();

		ProductsPage p = new ProductsPage(driver);

		// driver.findElements(By.xpath("//*[@text='ADD TO
		// CART']")).get(0).click();
		p.addCart().get(0).click();

		// driver.findElements(By.xpath("//*[@text='ADD TO
		// CART']")).get(0).click();
		p.addCart().get(0).click();

		// driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		p.cartButton().click();

		Thread.sleep(4000);
		CheckoutPage c = new CheckoutPage(driver);

		// count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		int count = c.listOfProducts().size();

		double sum = 0;
		for (int i = 0; i < count; i++) {
			String amount1 = c.listOfProducts().get(i).getText();
			double amount = getAmount(amount1);
			sum = sum + amount;

		}

		System.out.println("Actual: " + sum);

		// String getTotaltxt =
		// driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		String getTotaltxt = c.totalAmount().getText();

		/*
		 * getTotaltxt=getTotaltxt.substring(1); double getTotal =
		 * Double.parseDouble(getTotaltxt);
		 */

		double getTotal = getAmount(getTotaltxt);

		System.out.println("Expected: " + getTotal);
		Assert.assertEquals(sum, getTotal);
		driver.closeApp();
		service.stop();
	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double parseMethod = Double.parseDouble(value);
		return parseMethod;

	}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	
}
