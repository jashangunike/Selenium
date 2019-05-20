package checkBoxes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBOxTest {

	WebDriver driver;

	@BeforeTest
	public void openbrowser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Lib//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test
	public void checkboxTest() {

		Check_Box_Reuse cb = new Check_Box_Reuse(driver);
		// To select the Check Box
		cb.testCaseToCheck("bmwradio");
		
		// To DeSelect the Check Box
		cb.testCaseToUnCheck("bmwradio");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
