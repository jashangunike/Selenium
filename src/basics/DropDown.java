package basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

 /**
  * 
  * @author Dinesh Kumar Reddy
  * Asked in interview
  * Test Flow : - There are 8 values in DropdownBox,
		i want to know 4th value is existing or not, If the 4th value is exists
	 	i want to click that value of the 4th element , Otherwise Leave it.
  * 
  *
  */
public class DropDown {
	
	public WebDriver driver;

	@Test
	public void dropdown(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/account/create?specId=yidReg&lang=en-US&src=ym&done=https%3A%2F%2Fmail.yahoo.com&display=login&intl=us");
		
		// dropdown 
		
		WebElement birthele = driver.findElement(By.id("usernamereg-month"));
		Select db = new Select (birthele);
		List<WebElement> list = db.getOptions();
		
		String dropdown_Val = list.get(3).getText();
		System.out.println("4th value :"+dropdown_Val);
		
		int len = dropdown_Val.length();
		System.out.println(len);
		
		if(len>0)
		{
			db.selectByIndex(3);
		}else{
			System.out.println("Element is not there ");
		}
		
	}
}
