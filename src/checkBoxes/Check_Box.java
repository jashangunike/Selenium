package checkBoxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @author Dinesh Kumar Reddy
 *         About Test : - Working with Checkbox using Reusable Methods
 * @ReUsable_Methods : - 1.testCaseToCheck
 *                   - 2. testCaseToUnCheck
 *                   - 3.testCaseToCheckDesired
 * 
 * @see :-
 *      http://www.seleniumeasy.com/selenium-tutorials/working-with-checkbox-using-resuable-methods
 *
 */
public class Check_Box {

	private WebDriver driver;
	private String basePageURL;

	@Test
	public void testCaseToCheck() {
		driver = new FirefoxDriver();
		driver.get(basePageURL);
		WebElement checkBoxElement = driver.findElement(By.id("persist_box"));
		//Wait for the checkbox element to be visible
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkBoxElement));
		Select_The_Checkbox(checkBoxElement);
	}

	@Test
	public void testCaseToUnCheck() {
		driver.navigate().to(basePageURL);
		WebElement checkBoxElement = driver.findElement(By.id("persist_box"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkBoxElement));
		DeSelect_The_Checkbox(checkBoxElement);
	}

	@Test
	public void testCaseToCheckDesired() {
		driver.navigate().to("someother page");
		WebElement element = driver.findElement(By.cssSelector(".display"));
		Select_The_CheckBox_from_List(element, "soccer");
	}

	//Below method is used to Select a Checkbox, if it is not selected already
	public void Select_The_Checkbox(WebElement element) {
		try {
			if (element.isSelected()) {
				System.out.println("Checkbox: " + element + "is already selected");
			} else {
				// Select the checkbox
				element.click();
			}
		} catch (Exception e) {
			System.out.println("Unable to select the checkbox: " + element);
		}
	}

	//Below method is used to De-select a Checkbox, if it is selected already
	public void DeSelect_The_Checkbox(WebElement element) {
		try {
			if (element.isSelected()) {
				//De-select the checkbox
				element.click();
			} else {
				System.out.println("Checkbox: " + element + "is already deselected");
			}
		} catch (Exception e) {
			System.out.println("Unable to deselect checkbox: " + element);
		}
	}

	//Below method is used to select the checkbox with the specified value from multiple checkboxes.
	public void Select_The_CheckBox_from_List(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			System.out.println("Option value " + option.getText());
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}

}
