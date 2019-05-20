package basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.OpenBrowser3;

public class Frames_Handle extends OpenBrowser3 {

	@Test(enabled = false)
	public void Frame_handle() {

		// Switching frame by index
		d.switchTo().frame(2);

		// Switching frame by name - After switch to frame, u can find elements 
		d.switchTo().frame("Frame name");

		//We can even identify total number of iframes (frames) by using below snippet.
		int size = d.findElements(By.tagName("iframe")).size();
		System.out.println("Total Number of iframes are:" + size);
		
		// or 2nd example of finding total number of frames are
		List<WebElement> ele = d.findElements(By.tagName("iframe"));
		System.out.println("Number of frames in a page :" + ele.size());

		//to move back to parent frame
		d.switchTo().parentFrame();

		// if you want to get back to the main (or most parent) frame
		d.switchTo().defaultContent();
	}

	
	// To find frame name and frame id 
	@Test
	public void Frame_handle2() {

		//Count how many frames 
		List<WebElement> ele = d.findElements(By.tagName("iframe"));
		System.out.println("Number of frames in a page :" + ele.size());
		
		// Get frame names and id by using getAttribute method
		for (WebElement el : ele) {
			//Returns the Id of a frame.
			System.out.println("Frame Id :" + el.getAttribute("id"));
			//Returns the Name of a frame.
			System.out.println("Frame name :" + el.getAttribute("name"));
		}
	}

	@BeforeClass
	public void url() {
		d.get("http://demo.guru99.com/test/guru99home/");
		d.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
	}
}
