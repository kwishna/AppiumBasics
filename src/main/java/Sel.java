
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class Sel {

	public static void main(String[] args) throws Exception {

		FirefoxOptions f = new FirefoxOptions(); // f.addArguments("--headless");

		WebDriver d = new FirefoxDriver(f);
		d.get("https://google.com");
		System.out.println(d.getCurrentUrl());
//		 d.findElement(By.name("q")).sendKeys(Keys.chord(Keys.SHIFT, "t"));
		d.findElement(By.name("q")).sendKeys("Apple");
		d.findElement(By.name("q")).submit();
//		 new Actions(d).keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		Files.copy(((TakesScreenshot) d).getScreenshotAs(OutputType.FILE), new File("Aha.png"));
//		 new Actions(d).keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
		// ((JavascriptExecutor) d).executeScript("window.open('https://google.com');");

	}
}
