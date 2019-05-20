package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
/**
 * @author Dinesh Kumar Reddy
 * 	Explict_Wait : - The explicit wait is an intelligent kind of wait,
 *	- The explicit wait is used to tell the Web Driver to wait for certain conditions (Expected Conditions) 
 *		or the maximum time exceeded before throwing an "ElementNotVisibleException" exception.
 *	- It can be applied only for specified elements.Explicit wait gives better options
 *	 	than that of an implicit wait as it will wait for dynamically loaded Ajax elements.
 *
 */
public class ExplictWaitz {
	WebDriver driver;
	
	@Test
	public void Explicit_waits(){
		/**
		 * WebDriver Waits - Maximum element locators have 2 types 
		 * 						1. locate by locator
		 * 						2. By webElement 
		 * 					you can select one of them above.
		 */
		
		// WebDriver Waits 
		WebDriverWait wait = new WebDriverWait(driver,15);
		
		// wait until element located 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
		// wait until element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
		
		WebElement web_element = driver.findElement(By.id(""));
		wait.until(ExpectedConditions.elementToBeClickable(web_element));
		
		// wait until element to be selected by locator
		wait.until(ExpectedConditions.elementToBeSelected(By.id("By locator")));
		// by webElement
		wait.until(ExpectedConditions.elementToBeSelected(web_element));
		
		// title contains
		String text = "Its String type";
		wait.until(ExpectedConditions.titleContains(text));
		
		// Visibility of WebElement
		wait.until(ExpectedConditions.visibilityOf(web_element));
		
		// wait visibility of nested elements located by - locator and sub locator
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(By.xpath("locator"), By.xpath("sub_locator")));
		
		// wait visibility of nested elements located by - WebElement and sub locator
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(web_element, By.xpath("sub_locator")));
			
		// alert is present
		wait.until(ExpectedConditions.alertIsPresent());
	
	}
	}


