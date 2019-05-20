package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowser2 {

	/*public static WebDriver d;
	
	 public OpenBrowser2(WebDriver driver) {
			OpenBrowser2.d = driver;
	}*/

	
	public static void Chrome(WebDriver d) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();

	}

	
	public static void Firefox(WebDriver d) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Lib\\geckodriver.exe");
		d = new FirefoxDriver();
		d.manage().window().maximize();

	}

	
	public static void Edge(WebDriver d) {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Lib\\MicrosoftWebDriver.exe");
		d = new EdgeDriver();
		d.manage().window().maximize(); 

	}

	
	public static void ie(WebDriver d) {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Lib\\IEDriverServer.exe");
		d = new InternetExplorerDriver();
		d.manage().window().maximize();

	}
}
