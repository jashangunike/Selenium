package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class CrossBrowser {

	WebDriver d;

	@Parameters("Browser")
	@BeforeTest
	public void openBrowser(String BrowserName) {

		if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
			d = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Lib\\geckodriver.exe");
			d = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Lib\\IEDriverServer.exe");
			d = new InternetExplorerDriver();
		} else if (BrowserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\Lib\\MicrosoftWebDriver.exe");
			d = new EdgeDriver();
		} else {
			System.out.println("Browser name missmatch");
		}

		d.manage().window().maximize();
		d.get("https://www.google.co.in");
		System.out.println("title is :" + d.getTitle());
		d.close();

	}

	@AfterTest
	public void teardown() {
		d.close();
	}
}
