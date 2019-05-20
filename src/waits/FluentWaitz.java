package waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import com.google.common.base.Function;
/**
 * @author Dinesh Kumar Reddy
 * About Fluent Wait : - The fluent wait is used to tell the web driver to wait for a condition,
 *  					as well as the frequency with which we want to check the condition before throwing
 *  			 			an "ElementNotVisibleException" exception.
 * 		Frequency: Setting up a repeat cycle with the time frame to verify/check 
 *						the condition at the regular interval of time
 */
public class FluentWaitz {

	WebDriver driver;

	// Below code snippet will Wait 30 seconds for an element to be present on the page
		//and check for its presence once every 5 seconds.
	@Test
	public void fluent_wait() {

		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement SeleniumLink = fwait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(By.id("Element"));
				
			}
		});
		// ( here all the WebElement methods we can apply in that "selenumLink" element) Example - 
			// Click on that Element 
			SeleniumLink.click();
				// to get text 
				SeleniumLink.getText();
	}

}
