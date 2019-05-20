package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Dinesh Reddy
 *       -   we will learn to fetch all the links present on a webpage by using tagname locator.
 *         If you have basic understanding of HTML, you must be aware of the fact that all
 *         hyperlinks are of type anchor tag or 'a'.
 * 	
 *        Example : -  <a href="selenium-introduction.html">Selenium Introduction</a>
 *        My info :- By using "a" tag we can get the all links text 
 *        - All links are after href, So by using href tag name we can get all the links 
 */
public class Get_All_Links {

	public static WebDriver driver;

	@Test
	public void GetLinks() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Lib//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");

		//Identify the number of Links on webpage and assign into WebElement List 
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int links_size = links.size();
		System.out.println("Total Links are " + links_size);

		for (int i = 0; i < links.size(); i++) {
			// Printing the links Text
			System.out.println("Each Item Text are : " + links.get(i).getText());
			// To get the all Links
			System.out.println("links :- " + links.get(i).getAttribute("href"));

		}

		driver.close();
	}

}
