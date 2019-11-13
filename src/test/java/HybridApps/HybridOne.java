package HybridApps;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
/**
 * 
 * @author AB D
 *
 * If We Have The APK File With Us.
 */
public class HybridOne {
	
	private static AndroidDriver<WebElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		File apkFile = new File(System.getProperty("user.dir")+"/app.apk");
		
		DesiredCapabilities desiredCaps = new DesiredCapabilities();
		
		desiredCaps.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
		desiredCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		desiredCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		
		driver = new AndroidDriver<WebElement>(new URL("http://10.0.0.4:4723/wd/hub"), desiredCaps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(10000);
		driver.quit();
		System.out.println("*********************** Code Finished *******************");
	}
}
