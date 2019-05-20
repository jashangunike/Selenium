package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.OpenBrowser3;

public class Popup_Alert extends OpenBrowser3 {

	@Test(priority = 2)
	public void alert_popup() throws InterruptedException {
		// Switching to alert
		Alert alt = d.switchTo().alert();

		// To capture Alert message
		String alertMessage = d.switchTo().alert().getText();
		System.out.println("Alert Message is :" + alertMessage);
		Thread.sleep(3000);

		// To Accept alert box
		alt.accept();

		// to cancel alert box
		//alt.dismiss();

	}

	@Test(priority = 1)
	public void beforealert_operations() {
		d.findElement(By.name("cusid")).sendKeys("dinesh");
		d.findElement(By.name("submit")).click();
	}

	@BeforeClass
	public void url() {
		d.get("http://demo.guru99.com/test/delete_customer.php");

	}

}
