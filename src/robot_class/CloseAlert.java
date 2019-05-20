package robot_class;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Dinesh Kumar Reddy 
 * About Test : - closing pop-ups using Robot Class
 * Scenario : - unnecessary pop-ups appears on the screen which cannot be 
 * 				accepted or dismissed by using Alert interface, here we have only option is,
 * 			 	close down the window using shortcut keys = "Alt+ space bar + c". 
 * 				Let see how close the pop-up window using Robot class
 * 
 */
public class CloseAlert {
	WebDriver driver;

	@Test
	public void close_popup_using_Robot() throws AWTException, InterruptedException {

		driver.get("");
		Thread.sleep(200);
		// here we are using keyboard events  
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_SPACE);
		rb.keyPress(KeyEvent.VK_C);
		rb.keyPress(KeyEvent.VK_ALT);

		rb.keyRelease(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_ALT);

	}

	@BeforeTest
	public void openBrow() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tear_down() {
		driver.close();
	}

	
}
