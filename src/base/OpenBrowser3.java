package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class OpenBrowser3 {
	public WebDriver d;
	
	@BeforeTest
	public void open_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

	}

	@AfterTest
	public void close_browser() {
		d.close();
	}

}
