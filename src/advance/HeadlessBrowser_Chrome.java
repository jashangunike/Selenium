package advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

/**
 * @author Dinesh Reddy
 *         About Class :- Chrome Headless browser
 *
 */
public class HeadlessBrowser_Chrome {

	WebDriver d;

	@Test
	public void headlessChrome() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
		// Headless browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window=size=1400,800");
		options.addArguments("headless");
		d = new ChromeDriver(options);

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
