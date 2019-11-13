package Utils;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Utils {
	
	public static Dimension getDimensionOfScreen(WebDriver driver) {
		 return driver.manage().window().getSize();
	}
	
	public static TouchAction getTouchAction(AndroidDriver driver) {
		 return new TouchAction(driver);
	}
	
	public static PointOption getPointOption(AndroidDriver driver) {
		 return new PointOption();
	}
	
	public static void savePageSource(String data, String fileName) throws IOException {
		
		Path p = Paths.get(System.getProperty("user.dir")+"/"+fileName+".xml", null);
		if(!Files.exists(p, null)) {
			Files.createFile(p, null);
		}
			Writer r = Files.newBufferedWriter(p, null);
			r.append(data);
			r.flush();
			r.close();
	
	}

}
