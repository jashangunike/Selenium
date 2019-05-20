package robot_class;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/**
 * 
 * @author Dinesh Kumar Reddy
 * Test flow : - open the browser and url, closing the browser using robot class ( using keys )
 *             - ( We can also download the files using robot class in firefox.
 *             		- in firefox while downloading it asks the conformation to download 
 *             		the file, like : 
 *             			save as 
 *             			open with 
 *             		while using robot class, we can select the options by using robot keys.)
 *
 */
public class RobotCloseBrow {
	public static WebDriver driver;

	@Test(priority = 1)
	public void oprnbrow() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh Kumar Reddy\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void keyevents() throws AWTException {
		driver.get("https://www.google.co.in/?gfe_rd=cr&ei=OuwzWe2-JJqErAGHhpuoBA");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_SPACE);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rb.keyPress(KeyEvent.VK_C);

		rb.keyRelease(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_ALT);

	}

}
