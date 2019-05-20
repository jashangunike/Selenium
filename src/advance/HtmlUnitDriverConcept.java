package advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

/**
 * @author Dinesh Reddy
 * @HTMLUnitDriver: -
 *                  HTML UnitDriver is the most light weight and fastest implementation headless
 *                  browser for of WebDriver.
 *                  - It is based on HtmlUnit. It is known as Headless Browser Driver. It
 *                  is same as Chrome, IE, or FireFox driver, but it does not have GUI so one cannot
 *                  see the test execution on screen.
 *                  - For more info :- refer your onenote
 */
public class HtmlUnitDriverConcept {

	WebDriver d;

	@Test
	public void htmlunitdriver_headless() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");

		// you can use any browser - just you have to set the property of that browser
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Lib//geckodriver.exe");

		// Headless browser
		d = new HtmlUnitDriver();

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
