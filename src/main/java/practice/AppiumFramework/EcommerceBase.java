package practice.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class EcommerceBase {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public AppiumDriverLocalService startServer()
	{
		boolean flag=checkIfServerIsRunning(4723);
		if(!flag)
		{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try{
			serverSocket=new ServerSocket(port);
			serverSocket.close();
		}catch(IOException e){
			
			isServerRunning=true;
			
		}
		finally
		{
			serverSocket=null;
		}
		return isServerRunning;
		
	}
	
	
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException
	{
		
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practice\\AppiumFramework\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		//prop.get("GeneralStoreApp");
		
		
		File appDir = new File("src");
		File app = new File(appDir,(String)prop.get(appName));//"General-Store.apk"
		DesiredCapabilities cap=new DesiredCapabilities();
		
		//String device=(String)prop.get("device");
		String device=System.getProperty("deviceName");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);	
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,prop.get("automationname"));
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false)); //commented		
		/*cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);*/
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	public static void getScreenshot(String s) throws IOException
	{
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
				
		
	}
	
	

}