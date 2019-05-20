package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Dinesh Reddy
 *
 */
public class DragAndDrop {

	WebDriver d;

	@Test
	public void drag_and_drop() {
		// Find source and target Webelements
		WebElement source = d.findElement(By.id(""));
		WebElement target = d.findElement(By.id(""));

		Actions act = new Actions(d);
		act.dragAndDrop(source, target);

	}

	@BeforeClass
	public void get_url() {
		d.get("");

	}

	@BeforeTest
	public void open_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	@AfterTest
	public void close_browser() {
		d.close();
	}

}
