package log4j;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Log4jTest {

	WebDriver d;
	Logger log = Logger.getLogger(Log4jTest.class);

	@BeforeTest
	public void open_browser() {
		log.info("************************* Starting test cases execution  ********************************");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("https://www.google.co.in");
	}

	@Test(priority = 1)
	public void get_title() {

		String title = d.getTitle();
		System.out.println("Page title is :" + title);
		Assert.assertEquals(title, "Google");
	}

	@Test(priority = 2)
	public void gmail_link_displayed() {
		boolean isdisplayed = d.findElement(By.linkText("Gmail")).isDisplayed();
		Assert.assertTrue(isdisplayed);

	}

	@AfterTest
	public void closebrowser() {
		d.close();
	}

}
