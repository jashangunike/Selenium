package data_Driven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Dinesh Reddy
 * 
 *         About_This_Class : - Data Driven Testing Using Arrays
 *         - Here we are passing the userName and password data from arrays
 * 
 * @TestCase : - Enter username and password click
 *           - if username and password is correct then display - user is able to login otherwise
 *           user is not able to login.
 *
 * @Limitations_of_this_approach :- There are some limitations with this approach, right now we are
 *                               having limited set of data lets say 2 or 3 records, so we can use
 *                               this approach. But what if we have more then 50 records (if you
 *                               write this way this script not maintainable ), So what we will do
 *                               is, we will keep this data in separate Excel Sheet and run it.
 */
public class DDT_Login {
	WebDriver d;

	@Test(dataProvider = "LoginData")
	public void login(String Username, String Password) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Lib//chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.get("https://www.ebay.com/signin/");

		d.findElement(By.id("userid")).sendKeys(Username);
		d.findElement(By.id("pass")).sendKeys(Password);
		d.findElement(By.id("sgnBt")).click();

		Thread.sleep(5000);
		String pagetitle = d.getTitle();

		// Giving verification point 
		if (pagetitle.contains(pagetitle)) {
			System.out.println(" Username or Password is wrong, user not able to login");
		} else {
			System.out.println("User login successfull");
		}

		d.close();
	}

	// 2D array 
	/*	Here data type we are tacking Object, 
	 * 		because of if i create String type of array it will only accept the String type of value,
	 *  or if i create integer type of array it will also accept only integer values,
	 *  But username and password can be any type, So better to take Object type - it will store every type of data type 
	 */

	@DataProvider(name = "LoginData")
	public Object[][] passData() {

		Object[][] data = new Object[3][2]; // 3rows, 2 columns

		data[0][0] = "UserName1";
		data[0][1] = "Password1";

		data[1][0] = "UserName2";
		data[1][1] = "Password2";

		data[2][0] = "UserName3";
		data[2][1] = "Password3";

		return data;
	}

}
