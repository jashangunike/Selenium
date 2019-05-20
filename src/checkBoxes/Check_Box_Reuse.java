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
 *         - Just Create reference object of this class and you can call below methods
 * @ReUsable_Methods:- 1.testCaseToCheck
 *                   - 2. testCaseToUnCheck
 *                   - 3.testCaseToCheckDesired
 *                   - 4. Get_The_NubmerOf_Checkboxes - not implemented - need to implement
 * 
 * @see :-
 *      http://www.seleniumeasy.com/selenium-tutorials/working-with-checkbox-using-resuable-methods
 *
 */
public class Check_Box_Reuse {

	private WebDriver driver;
	private String basePageURL;

	public Check_Box_Reuse(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void testCaseToCheck(String Element_id) {
		//driver = new FirefoxDriver();
		//driver.get(basePageURL);
		WebElement checkBoxElement = driver.findElement(By.id(Element_id)); //"bmwradio"
		//Wait for the checkbox element to be visible
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(checkBoxElement));
		Select_The_Checkbox(checkBoxElement);
	}

	@Test
	public void testCaseToUnCheck(String Element_id) {
		//driver.navigate().to(basePageURL);
		WebElement checkBoxElement = driver.findElement(By.id(Element_id));
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
				// you can uncomment this if you don't want to display
				System.out.println("Checkbox: " + element + "is already not selected, Now its Selected");
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
				System.out.println("Checkbox: " + element + "is deselected"); // you can uncomment this if you don't want to display
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

	@Test(enabled = false) // not implemented - need to implement
	public void Get_The_NubmerOf_Checkboxes() {
		// Find the checkbox or radio button element by its name.
		List<WebElement> checkboxes = driver.findElements(By.name("checkbox"));

		// Get the number of checkboxes available.
		int count = checkboxes.size();

		// Now, iterate the loop from first checkbox to last checkbox.
		for (int i = 0; i < count; i++) {

			// Store the checkbox name to the string variable, using 'Value' attribute
			String sValue = checkboxes.get(i).getAttribute("value");

			// Select the checkbox if its value is the same that you want.
			if (sValue.equalsIgnoreCase("checkbox")) {

				checkboxes.get(i).click();

				// This statement will get you out of the for loop.
				break;
			}

		}
	}
}
