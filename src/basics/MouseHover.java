package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.OpenBrowser3;

/**
 * @author Dinesh Reddy
 *
 *	About Class - Mouse Hover 
 *				- there is  no verification point in this program, if you want you can add
 */
public class MouseHover extends OpenBrowser3 {

	@Test
	public void mouseHover() {

		Actions mouse = new Actions(d);
		WebElement menu = d.findElement(By.xpath("//a[@href='#'][contains(text(),'CRM')]"));
		mouse.moveToElement(menu).build().perform();

		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Click the submenu link or dropdown menu link
		d.findElement(By.partialLinkText("Automotive CRM")).click();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@BeforeClass
	public void url() {
		d.get("https://freecrm.com/");
	}
}
