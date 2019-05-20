package basics;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.OpenBrowser3;

public class ReadCaptcha extends OpenBrowser3 {

	@Test
	public void readCaptcha() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Captcha");
		String captcha = scan.nextLine();
		// manually see the captcha in website and enter the captcha in eclipse console, it will reflect to browser
		// There is no way to read captcha automatically
		d.findElement(By.partialLinkText("")).sendKeys(captcha);

		// After entering the captcha, click oogin button
		d.findElement(By.id("Login_button")).click();
	}

}
