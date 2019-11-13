package HybridApps;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.HasDeviceTime;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class HybridTwo_WithoutAPK {

	private static AndroidDriver<WebElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\Krishna Singh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\AppiumLog\\appium.log")) // Generation Log File [Optional]
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)); // For Local Time Zone In Log. By Default GMT [Optional]
		
		service.start();
		
		DesiredCapabilities desiredCaps = new DesiredCapabilities();
		
		desiredCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		desiredCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		desiredCaps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		desiredCaps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
		desiredCaps.setCapability(MobileCapabilityType.APPLICATION_NAME, "UiAutomator2");
		
		driver = new AndroidDriver<WebElement>(new URL("http://10.0.0.11:4723/wd/hub"), desiredCaps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		Thread.sleep(3000);
		
		String time = ((HasDeviceTime) driver).getDeviceTime();
		System.out.println("::::::::::::::::::::::::::::::::: "+time+" :::::::::::::::::::::::::::::::::::");
		
		WebElement element = driver.findElement(By.id("io.selendroid.testapp:id/my_text_field"));
		element.click();
		
		driver.pressKey(new KeyEvent(AndroidKey.A));
		driver.pressKey(new KeyEvent(AndroidKey.B));
		driver.pressKey(new KeyEvent(AndroidKey.C));
		driver.pressKey(new KeyEvent(AndroidKey.D));
		
		Coordinates co = ((Locatable) element).getCoordinates();
		Point p = co.onPage();
		System.out.println("X ::::::::::::::::::: "+p.getX());
		System.out.println("Y ::::::::::::::::::: "+p.getY());
		
		p.move(10, 10);
		System.out.println("X1 ::::::::::::::::::: "+p.getX());
		System.out.println("Y1 ::::::::::::::::::: "+p.getY());
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.longPressKey(new KeyEvent(AndroidKey.HOME));
		
		Thread.sleep(10000);
		driver.quit();
		service.stop();
		System.out.println("************** COMPLETED ****************");
		
//		StringSelection user = new StringSelection("RajKuc");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(user, null);

	}

}
