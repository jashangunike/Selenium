package basics;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.OpenBrowser3;

/**
 * @author Dinesh Reddy
 *
 */
public class MouseScroll extends OpenBrowser3 {

	@Test
	public void mouse_scroll() throws InterruptedException {

		// mouse scroll down
		JavascriptExecutor scroll_down = (JavascriptExecutor) d;
		scroll_down.executeScript("window.scrollBy(0,600)", "");
		// For testing purpose am using thread.sleep
		Thread.sleep(5000);

		// Mouse Scroll up
		JavascriptExecutor scroll_up = (JavascriptExecutor) d;
		scroll_up.executeScript("window.scrollBy(0,-300)", "");

		Thread.sleep(5000);
	}

	@BeforeClass
	public void get_url() {
		d.get("https://freecrm.com/");
	}

}
