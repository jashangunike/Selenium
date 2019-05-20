package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumAllCommands {
	
	public WebDriver driver;

	@Test
	public void commands() {

		// Creating the new instance of Firefox
		driver = new FirefoxDriver();

		// To Open URl
		driver.get("URl");

		// Clicking on any element or button
		driver.findElement(By.id("button")).click();
		
		// submit method for submit form
		driver.findElement(By.id("")).submit();

		// Get Page source
		driver.getPageSource();

	}

	@Test
	public void Browser_Navigation_Methods() {

		// Navigate to URL
		driver.navigate().to("url");

		// Navigate back
		driver.navigate().back();

		// Navigate Forword
		driver.navigate().forward();

		// refresh page
		driver.navigate().refresh();

		// close the current browser
		driver.close();

		// Close the all tabs in browser
		driver.quit();

	}
	
	@Test
	public void String_based_Commands(){
		
		String title;
		String Curent_Url;
		String Page_source;
		String Get_text;
		
		// To get title
		title = driver.getTitle();
		
		// Get Curent URL
		Curent_Url = driver.getCurrentUrl();
		
		// Get Page source 
		Page_source = driver.getPageSource();
		
		// get text
		Get_text = driver.findElement(By.id("")).getText();
	}
	
	@Test
	public void methods2(){
		
		// Type in text area
		driver.findElement(By.id("")).sendKeys("text");
		
		// Clear the text area
		driver.findElement(By.name("")).clear();
		
	}
	
	@Test
	public void Getting_The_Attributes(){
		
		// Getting the attributes 
		WebElement email;
		email = driver.findElement(By.xpath(""));
		
		// you can store the attributes type of String		
		String Atribute_type = email.getAttribute("type");
		
		email.getAttribute("id");
		email.getAttribute("name");
		email.getAttribute("tagname");
		email.getAttribute("tagname");
		email.getAttribute("classname"); // And more......
		
	}
	
	@Test
	public void boolean_status(){
		// These boolean values are return true or false values
		
		// To get Element Displayed status
		boolean ele_status = driver.findElement(By.id("")).isDisplayed();
		System.out.println(ele_status); // if the element is displayed the status will come "true" otherwise "false"
		
		// To get Element Enabled status
		boolean Ele_status_enabled = driver.findElement(By.id("")).isEnabled();
		
		// To get Element is selected or not status
		boolean ele_status_selected = driver.findElement(By.id("")).isSelected();
	}
	
	@Test
	public void frames(){
		// you can switch to frames in 2 ways 
			// Frames priority is from left side to right side
		driver.switchTo().frame(2);// give the index value 
		driver.switchTo().frame("Frame name"); // Give the frame name 
		}
	
	
	@Test
	public void waits(){
		
		//  pause the for defined time
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// implicit wait - once we set the time webdriver to wait for certain amount of time before it throws "NoSuchElementException"	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		/**
		 * WebDriver Waits - Maximum element locators have 2 types 
		 * 						1. locate, by locator
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
