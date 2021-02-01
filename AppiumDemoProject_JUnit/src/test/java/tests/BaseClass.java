package tests;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class BaseClass {
	AppiumDriver<MobileElement> driver;
	@Before
	public void setup () {
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(CapabilityType.VERSION,"10.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3a API 30");
			caps.setCapability(MobileCapabilityType.UDID,"");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,100);
			caps.setCapability(MobileCapabilityType.APP,"D:\\QA_DevOps\\Pruebas Android - Appium\\Calculator_v7.8.apk");
			caps.setCapability("noResetValue","false"); 
			//caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url,caps);
			driver = new AndroidDriver<MobileElement>(url,caps);
			
		}catch(Exception exp) {
			System.out.println("Cause is: "+exp.getCause());
			System.out.println("Message is: "+exp.getMessage());
			exp.printStackTrace();
		}
	
	}
	@Test
	public void testCal() throws Exception {
		   //locate the Text on the calculator by using By.name()
			
		   WebElement seis=driver.findElementById("com.google.android.calculator:id/digit_6");
		   seis.click();
			
		   driver.findElementById("com.google.android.calculator:id/op_add").click();
		   
		   WebElement cinco=driver.findElementById("com.google.android.calculator:id/digit_5");
		   cinco.click();
		   
		   driver.findElementById("com.google.android.calculator:id/eq").click();
		   
		   Thread.sleep(5000);
		   
		}
	@After
	public void teradown() {
		driver.quit();
	}
}
