package Locators;

import static Utils.Utils.savePageSource;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
@SuppressWarnings({"rawtypes", "unused"})
public class LocatorOne {

	private static AppiumDriverLocalService service;
//	private static AndroidDriver<WebElement> driver;

//	private static AndroidDriver<MobileElement> driver1;
	public static AndroidDriver<AndroidElement> driver2;
	private static WebDriverWait wait;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException {

//		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
//				.withAppiumJS(new File(
//						"C:\\Users\\Krishna Singh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
//
//		service.start();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
//		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
//		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");

		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.html5test.webview");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "main.java.MainActivity");
		
		caps.setCapability(MobileCapabilityType.APP, "E:\\Bhole_Nath\\Eclipse_WorkSpace\\WorkSpace_2\\AppiumOne\\html.apk");
		
//		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.science.news.online");
//		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.appyet.activity.MainActivity");
		
		driver2 = new AndroidDriver<AndroidElement>(new URL("http://192.168.1.12:4723/wd/hub"), caps);
		driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver2, 30);
	}

	@Test(description = "Locator Test", enabled = false)
	public void keyBoard() throws InterruptedException {

//		driver.findElement(MobileBy.AccessibilityId("my_text_fieldCD")).click();
// 		xpath = //*[@content-desc='my_text_fieldCD']
// 		In Appium, text Is An Attribute. Hence, @text='Something' Is Correct

		driver2.findElement(MobileBy
				.xpath("//android.widget.LinearLayout/android.widget.EditText[@content-desc='my_text_fieldCD']"))
				.click();
		driver2.findElement(MobileBy
				.xpath("//android.widget.LinearLayout/android.widget.EditText[@content-desc='my_text_fieldCD']"))
				.sendKeys("DOWN");
		driver2.pressKey(new KeyEvent(AndroidKey.A));
		driver2.pressKey(new KeyEvent(AndroidKey.A));
		driver2.pressKey(new KeyEvent(AndroidKey.A));
		driver2.pressKey(new KeyEvent(AndroidKey.A));
		driver2.pressKey(new KeyEvent(AndroidKey.A));
		Thread.sleep(2000);
		driver2.hideKeyboard();
		driver2.closeApp();
	}

	@Test(enabled = false)
	public void lock() throws InterruptedException {

		Dimension d = driver2.manage().window().getSize();
		int x = d.getWidth();
		int y = d.getHeight();
		System.out.println("X Is ::: " + x + " , " + " Y Is ::: " + y);

		if (driver2.isDeviceLocked()) {
			driver2.unlockDevice();
		} else
			System.out.println("Device Not Locked");
	}

	@Test(enabled = false)
	public void notification() {

		driver2.openNotifications();
//		driver.findElement(By.id("com.android.systemui:id/dismiss_view")).click();
	}

	@Test(enabled = false)
	public void removeAndInstallApp() {
		
		driver2.removeApp("io.selendroid.testapp");
		System.out.println("Status Of The Application ::: " + driver2.isAppInstalled("io.selendroid.testapp"));

		if (!driver2.isAppInstalled("io.selendroid.testapp")) {
			driver2.installApp(System.getProperty("user.dir") + "/app.apk");
			driver2.startActivity(new Activity("io.selendroid.testapp", ".HomeScreenActivity")); // Start Or Switch
																									// Application
		}
	}

	@Test(enabled = false)
	public void keyCode() {

		driver2.startActivity(new Activity("com.android.contacts", ".activities.TwelveKeyDialer"));
//		driver2.pressKeyCode(4); // Search For Key Codes' Job. 4 Means Back Key
		driver2.longPressKey(new KeyEvent(AndroidKey.BACK));
	}

	@Test(enabled=false)
	public void dragAndDrop() throws IOException, InterruptedException {
		
//		driver2.installApp(System.getProperty("user.dir") + "/drag-sort.apk");
		driver2.startActivity(new Activity("com.mobeta.android.demodslv", ".Launcher")); // Opening Sorting App. 
		
		String text1 = "Basic";
		driver2.findElementByAndroidUIAutomator("new UiSelector().textContains(\"" + text1 + "\")").click();// https://developer.android.com/reference/androidx/test/uiautomator/UiSelector.html
		
		String text = "com.mobeta.android.demodslv:id/text";

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"" + text + "\")")));
		
		savePageSource(driver2.getPageSource(), "sort"); // Saving The XML Into A File
		
		AndroidElement start = driver2.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Brad')]/preceding-sibling::android.widget.ImageView"));
		AndroidElement end = driver2.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Kurt')]/preceding-sibling::android.widget.ImageView"));
		
		TouchAction<?> action = new TouchAction(driver2);
		
//		Coordinates c = end.getCoordinates();
//		action.longPress(new LongPressOptions().withElement(new ElementOption().withElement(start))).moveTo(PointOption.point(c.onScreen().getX(), c.onScreen().getY()));
		
		action.longPress(new LongPressOptions().withElement(new ElementOption().withElement(start))).moveTo(new ElementOption().withElement(end)).release().perform();
		Thread.sleep(3000);
	}
	

	@Test(enabled=false)
	public void multiTouch() throws IOException, InterruptedException {
		
		driver2.startActivity(new Activity("com.rn.yamtt", ".MainActivity")); // Opening YAMTT App.
		driver2.findElement(By.id("com.rn.yamtt:id/buttonLaunchTouch")).click();
		
		Thread.sleep(2000);
		
		TouchAction action1 = new TouchAction(driver2).tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(100, 100))).moveTo(new PointOption().withCoordinates(100, 200));
		TouchAction action2 = new TouchAction(driver2).tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(200, 200))).moveTo(new PointOption().withCoordinates(100, 300));
		TouchAction action3 = new TouchAction(driver2).tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(300, 300))).moveTo(new PointOption().withCoordinates(100, 400));
		TouchAction action4 = new TouchAction(driver2).tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(400, 400))).moveTo(new PointOption().withCoordinates(100, 500));
		TouchAction action5 = new TouchAction(driver2).tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(500, 500))).moveTo(new PointOption().withCoordinates(100, 600));
		
//		action1.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2000)));
//		action2.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2000)));
//		action4.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2000)));
//		action5.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2000)));
//		action3.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2000)));
		
		new MultiTouchAction(driver2).add(action1).add(action2).add(action3).add(action4).add(action5).perform();
		
	}
	
	@Test(enabled=false)
	public void contactsScrollAction() { // Contacts Dialer
		
		driver2.startActivity(new Activity("com.android.contacts","activities.PeopleActivity"));
		
		String text = "Aka";
		driver2.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/list\")).scrollIntoView(new UiSelector().textContains(\""+text+"\"))")).click();
	}
	
	@Test(enabled=false)
	public void swipe() throws InterruptedException { // Contacts Dialer
		
		driver2.startActivity(new Activity("com.android.contacts","activities.PeopleActivity"));
		
		String text = "Aka";
		
		AndroidElement phoneNo = driver2.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/list\")).scrollIntoView(new UiSelector().textContains(\""+text+"\"))"));
		
		
		//Swipe Left To Right
		new TouchAction(driver2).longPress(new PointOption().withCoordinates(100, 1000)).moveTo(new PointOption().withCoordinates(500, 1000)).release().perform();
		Thread.sleep(5000);
	}
	
	@Test(enabled=false)
	public void amazonSwipe() throws InterruptedException { // Amazon Search
		
// 		To Run This Test Set The Capabilities With Amazon AppPackage & AppActivity
//		caps.setCapability("appPackage", "in.amazon.mShop.android.shopping");
//	    caps.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		
		driver2.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
//		Thread.sleep(2000);
		
		AndroidElement searchBox = driver2.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text"));
		searchBox.click();
		searchBox.clear();
		
		driver2.pressKey(new KeyEvent(AndroidKey.L));
		driver2.pressKey(new KeyEvent(AndroidKey.A));
		driver2.pressKey(new KeyEvent(AndroidKey.P));
		driver2.pressKey(new KeyEvent(AndroidKey.T));
		driver2.pressKey(new KeyEvent(AndroidKey.O));
		driver2.pressKey(new KeyEvent(AndroidKey.P));
		driver2.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		String text = "Apple";
		driver2.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"in.amazon.mShop.android.shopping:id/rs_stack_view_container\")).scrollIntoView(new UiSelector().textContains(\""+text+"\"))")).click();
	
		Thread.sleep(5000);	
	}
	
	@Test(enabled=false)
	public void nativeApps() throws InterruptedException {
		
		/**
		 * Native Apps Do Have 2 Views : Web View & Native App
		 * We Are Required To Switch Between The Views To Access Its Elements.
		 * Just Like WindowHandles In Webdriver.
		 */
		
//		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.science.news.online");
//		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.appyet.activity.MainActivity");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.science.news.online:id/name")));

		driver2.findElement(By.xpath("//*[contains(@text, 'Last 24')]")).click();
		Thread.sleep(5000);
		
		driver2.findElement(By.xpath("//*[contains(@text, 'Robot')]")).click();
		driver2.findElement(By.xpath("//*[contains(@text, 'Visit')]")).click();
		
		Thread.sleep(8000);
		
		Set<String> handles = driver2.getContextHandles();
		
		for(String s : handles) {
			
			System.out.println(s);
			
			if(s.contains("WEB")) {
				
				driver2.context(s); // Switching Context
			}
		}
		
		boolean isDisplayed = driver2.findElement(By.xpath("//div[@id='item_40719']//p[1]")).isDisplayed();
		System.out.println(":::::: :::::: "+isDisplayed+" :::::: ::::::");
	}
	
	@Test(enabled=true, description="Facing Chromedriver Issue")
	public void nativeApp2() throws InterruptedException {
		
//		driver2.installApp("C:\\Users\\Krishna Singh\\Downloads\\"+ "html.apk");
		driver2.startActivity(new Activity("com.html5test.webview", "main.java.MainActivity"));
		
		driver2.findElement(By.id("com.html5test.webview:id/et")).click();
		driver2.findElement(By.id("com.html5test.webview:id/et")).clear();
		
		driver2.findElement(By.id("com.html5test.webview:id/et")).sendKeys("http://www.google.co.in");
		driver2.findElement(By.id("com.html5test.webview:id/go")).click();
		
		Thread.sleep(4000);
		
		Set<String> handles = driver2.getContextHandles();
		
		for(String s : handles) {
			
			System.out.println(s);
			
			if(s.contains("WEB")) {
				
				driver2.context(s); // Switching Context
			}
		}
		
		driver2.findElement(By.name("q")).sendKeys("Hello World");
		driver2.findElement(By.xpath("button[@class='Tg7LZd']")).click();
		
		boolean isDisplayed = driver2.findElement(By.xpath("//*[contains(text(),'ello')]")).isDisplayed();
		
		
		Thread.sleep(500000);
	}
	
	@Test(enabled=false)
	public void elementImageFromFullScreenshot() throws IOException {
		
//		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.biiteducation.atul.javascript");
//		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".SplashScreen");
		
//		driver2.pressKey(new KeyEvent(AndroidKey.HOME));
		File srcFile = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
		File desFile = new File(System.getProperty("user.dir")+"/screenshot/screenshot.png");

		AndroidElement ele = driver2.findElement(By.id("com.biiteducation.atul.javascript:id/tvTitle"));
		
		BufferedImage fullImg = ImageIO.read(srcFile);
		
		Point p = ele.getLocation();
		int width = ele.getSize().getWidth();
		int height = ele.getSize().getHeight();
		
		BufferedImage element = fullImg.getSubimage(p.getX(), p.getY(), width, height);
		System.out.println(ImageIO.write(element, "PNG", new File(System.getProperty("user.dir")+"/screenshot/subImage.PNG")));
		
		FileUtils.copyFile(srcFile, desFile);
	}
	
	@Test(enabled=false, dependsOnMethods= {"elementImageFromFullScreenshot"})
	public void textFromImage() throws IOException {
		
		File textImage  = new File(System.getProperty("user.dir")+"/screenshot/subImage.PNG");
		
		ITesseract tess = new Tesseract();
		tess.setDatapath(System.getProperty("user.dir"));
		tess.setLanguage("eng");
		
		String textFromImage = null;
		
		try {
				textFromImage = tess.doOCR(textImage);
				
			}catch(TesseractException e) {
				
				System.err.println(e.getMessage());  
		}  
		
		System.out.println("Extracted Text From Image Is ::: "+textFromImage);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		driver2.quit();
//		service.stop();
	}
}
