package advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

/**
 * @author Dinesh Reddy
 *
 */
public class HeadlessBrowser_Firefox {

	WebDriver d;

	@Test
	public void firefox_headlessBrowser() {

		FirefoxBinary firefoxbinary = new FirefoxBinary();
		firefoxbinary.addCommandLineOptions("--headless");

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Lib//geckodriver.exe");

		FirefoxOptions fo = new FirefoxOptions();
		fo.setBinary(firefoxbinary);
		d = new FirefoxDriver(fo);

		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		// testCase are 
		d.get("https://www.google.co.in");
		String title = d.getTitle();
		System.out.println("Title of the page is :" + title);

		WebElement gmail = d.findElement(By.partialLinkText("Gmail"));

		gmail.click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String after_click_gmail = d.getTitle();
		System.out.println("After clicking the Gmail link Title is :" + after_click_gmail);

		d.close();

	}

}
