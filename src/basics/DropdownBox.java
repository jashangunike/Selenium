package basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Dinesh Reddy
 * 
 *         About Dropdownbox Class :-
 *
 */
public class DropdownBox {

	WebDriver d;

	@Test
	public void dropdownbox() {

		// Find dropdownbox webelement
		WebElement db_ele = d.findElement(By.id("month"));
		Select db = new Select(db_ele);

		// Select Drop Down Box Elements
		db.selectByIndex(2);

		// to know selected value name
		WebElement options = db.getFirstSelectedOption();
		String db_selected = options.getText();
		System.out.println("Dropdown box selected value is :" + db_selected);

//		db.selectByValue("value");
//		db.selectByVisibleText("visable text");

		// Count how many elements in the dropdownbox
		List<WebElement> count_ele = db.getOptions();
		int size_of_elements = count_ele.size();
		System.out.println("Total Dropdown box count is: " + size_of_elements);

		// To print all dropdownbox values
		for (int i = 0; i < size_of_elements; i++) {
			String db_values_list = count_ele.get(i).getText();
			System.out.println("Dropdownbox values  are :" + db_values_list);
		}

		// To deselect dropdownbox value
//		db.deselectAll();
//		db.deselectByIndex(2);
//		db.deselectByValue("");
//		db.deselectByVisibleText("");

	}

	@BeforeClass
	public void url() {
		d.get("https://www.facebook.com/");
	}

	@BeforeTest
	public void open_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void Close_browser() {
		d.close();
	}

}
