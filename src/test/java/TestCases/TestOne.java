package TestCases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
/**
 * 
 * @author AB D
 *
 * First Appium Code.
 * Using Chrome Browser For Testing!
 * - WebApp Testing -
 * 
 */
public class TestOne {
	
	private static AndroidDriver<WebElement> driver;
	
	public static void main(String... args) throws MalformedURLException, InterruptedException {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\Krishna Singh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\AppiumLog\\appium.log")) // Generation Log File [Optional]
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)); // For Local Time Zone In Log. By Default GMT [Optional]
			
		service.start();
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//		desiredCapabilities.setCapability("browserName", "chrome");
//		desiredCapabilities.setCapability("deviceName", "Redmi");
//		desiredCapabilities.setCapability("platformVersion", "7.1.2");
		
		desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		desiredCapabilities.setCapability("platformVersion", "7.1.2");
		
		driver = new AndroidDriver<WebElement>(new URL("http://192.168.1.12:4723/wd/hub"), desiredCapabilities); // ipconfig ipv4 Address
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Krishna Kumar Singh");
		driver.findElement(By.xpath("//button[@jsname='Tg7LZd']")).click();
		Thread.sleep(5000);
		driver.close();
		service.stop();
		
	}
}
