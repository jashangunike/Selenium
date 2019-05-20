package screen_shots;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.OpenBrowser3;

/**
 * @author Dinesh Reddy
 * 
 *         About class - Screenshot for failed test cases
 *         - Here we are using @AfterTest method and ITestRedult
 * @ITestResult - it is separate interface - we have to import from testNG
 *              - we can take screenshot like,
 *              #TestCase - failure or skip or started or success
 * 
 *
 */
public class ScreenShot_FailedTC extends OpenBrowser3 {

	//WebDriver d;

	@AfterMethod
	public void teardown(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {

			ScreenShot_Reuse.takeScreenShot(d, result.getName());
			// result.getName() - it will return the failed test case name as screenshot name
		}

	}

	// Finding WebElements in Facebook page
	By FirstName = By.id("u_0_j");
	By LastName = By.id("wrong id");

	@Test(priority = 0)
	public void url() {
		d.get("https://www.facebook.com/");
	}

	@Test(priority = 1)
	public void testcase1() {

		d.findElement(FirstName).sendKeys("Dinesh");
	}

	@Test(priority = 2)
	public void testcase2() {

		// here we are forcefully failing the test case, by entering the wrong WebElement or WebElement are not given
		d.findElement(LastName).sendKeys("Reddy");
	}

	@Test(priority = 3)
	public void method3() {

		String title = d.getTitle();
		System.out.println("Title of the page is :" + title);
		Assert.assertEquals(title, title);

	}

	@Test(priority = 4, enabled = false)
	public void testcase4() {

		String title = d.getTitle();
		System.out.println("Title of the page is :" + title);
		Assert.assertEquals("", "");

	}

}
