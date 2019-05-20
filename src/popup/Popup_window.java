package popup;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Popup_window {
	WebDriver d;

	@Test(priority = 1)
	public void popup_window_handle() {

		// It will return the parent window name as a String
		String parentwindow = d.getWindowHandle();

		// Current window title
		String current_window_title = d.getTitle();
		System.out.println("Current window title is :" + current_window_title);

		// to know how many popup windows are opened and count them
		Set<String> windows_handle = d.getWindowHandles();
		int windows_count = windows_handle.size();
		System.out.println("Total popup windows are :" + windows_count);

		// switch to Parent window
		d.switchTo().window(parentwindow);

	}

	@BeforeClass
	public void url() {
		d.get("https://www.naukri.com/");
	}

	@BeforeSuite
	public void open_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void close_browser() {
		// d.close();
		d.quit();
	}

}
