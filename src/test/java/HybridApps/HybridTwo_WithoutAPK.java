package HybridApps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HybridTwo_WithoutAPK {

	static AppiumDriverLocalService service;
	private static AndroidDriver<WebElement> driver;

	public static void startAppiumServer() {
		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder()
						.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(new File("C:\\Users\\Krishna Singh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withLogFile(new File(System.getProperty("user.dir") + "\\AppiumLog\\appium.log")) // Generation Log File [Optional]
						.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)); // For Local Time Zone In Log. By Default GMT [Optional]

		service.start();
	}

	private static void stopAppiumServer(){
		service.stop();
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		try {

			startAppiumServer();
			DesiredCapabilities desiredCaps = new DesiredCapabilities();

			desiredCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 7A");
			desiredCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			desiredCaps.setCapability(MobileCapabilityType.APP, "selendroid-test-app-0.17.0.apk");
			desiredCaps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
			desiredCaps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
			desiredCaps.setCapability(MobileCapabilityType.APPLICATION_NAME, "UiAutomator2");

			driver = new AndroidDriver<>(new URL("http://192.168.1.12:4723/wd/hub"), desiredCaps);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
			driver.pressKey(new KeyEvent(AndroidKey.BACK));

			Thread.sleep(3000);

			String time = driver.getDeviceTime();
			System.out.println("::::::::::::::::::::::::::::::::: " + time + " :::::::::::::::::::::::::::::::::::");

			WebElement element = driver.findElement(By.id("io.selendroid.testapp:id/my_text_field"));
			element.click();

			driver.pressKey(new KeyEvent(AndroidKey.A));
			driver.pressKey(new KeyEvent(AndroidKey.B));
			driver.pressKey(new KeyEvent(AndroidKey.C));
			driver.pressKey(new KeyEvent(AndroidKey.D));

			Coordinates co = ((Locatable) element).getCoordinates();
			Point p = co.onPage();
			System.out.println("X ::::::::::::::::::: " + p.getX());
			System.out.println("Y ::::::::::::::::::: " + p.getY());

			p.move(10, 10);
			System.out.println("X1 ::::::::::::::::::: " + p.getX());
			System.out.println("Y1 ::::::::::::::::::: " + p.getY());

			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.longPressKey(new KeyEvent(AndroidKey.HOME));

			Thread.sleep(10000);
			driver.quit();
		} finally {

			stopAppiumServer();
			System.out.println("************** COMPLETED ****************");
		}
//		StringSelection user = new StringSelection("RajKuc");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(user, null);

	}

}
