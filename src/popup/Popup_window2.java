package popup;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @author Dinesh Reddy
 * 
 *         *********Approach to handle multiple windows in selenium webdriver*********
 *         We also have getWindowNames, which will return Set<String> it means
 *         the set of window name then we can iterate using Iterator. The set is
 *         part of Java collection which allows us to handle multiple sets of
 *         data dynamically.
 * 
 *         Scenario 1: - In some application, you will get some Pop up that is
 *         nothing but separate windows takes an example of naukri.com.
 *         Therefore, in this case, we need to close the popup and switch to the
 *         parent window.
 * 
 *         Complete program to handle multiple windows in selenium webdriver
 * 
 *         First, we will switch to child window (pop up window) then we will
 *         close it and then we will switch to the parent window.
 * 
 *         Refer link - http://learn-automation.com/handle-multiple-windows-in-selenium-webdriver/
 */
public class Popup_window2 {
	WebDriver d;

	@Test
	public void TestPopUp() throws InterruptedException {
		// Open browser
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		//d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// Maximize browser
		d.manage().window().maximize();

		// Load app
		d.get("http://www.naukri.com/");

		// It will return the parent window name as a String
		String parent = d.getWindowHandle();

		// This will return the number of windows opened by Webdriver and will return Set of Strings
		Set<String> s1 = d.getWindowHandles();

		// Now we will iterate using Iterator
		Iterator<String> I1 = s1.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			// Here we will compare if parent window is not equal to child window then we will close

			if (!parent.equals(child_window)) {
				d.switchTo().window(child_window);

				System.out.println(d.switchTo().window(child_window).getTitle());

				d.close();
			}

		}
		// once all pop up closed now switch to parent window
		d.switchTo().window(parent);

	}
}
