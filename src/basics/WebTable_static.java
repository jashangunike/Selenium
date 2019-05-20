package basics;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.OpenBrowser3;

public class WebTable_static extends OpenBrowser3 {

	@Test
	public void webTable_static() throws InterruptedException {

		d.findElement(By.id("")).click();
		Thread.sleep(3000);
		// from the date box - click perticular date 
		d.findElement(By.xpath("x path of the date")).click();

	}

}
