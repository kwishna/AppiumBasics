package TestCases;

import HybridApps.HybridTwo_WithoutAPK;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStack {

	public static final String USERNAME = "baba123";
	public static final String AUTOMATE_KEY = "D3BxRYBJrHutSx3LZtvm";
	public static final String U = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws MalformedURLException {

		MutableCapabilities caps = new DesiredCapabilities();
/*		caps.setCapability("browserName", "android");
		caps.setCapability("device", "Samsung Galaxy S9 Plus");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "9.0");*/

		HybridTwo_WithoutAPK.startAppiumServer();

		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 7A");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");

		AndroidDriver driver = new AndroidDriver(new URL(U), caps);
		driver.get("https://google.co.in");
		driver.findElement(new By.ByName("q")).sendKeys("Krishna");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//		driver.findElement(By.name("btnK")).submit();
		System.out.println(driver.findElements(By.className("r")).size());

		driver.quit();
	}
}
