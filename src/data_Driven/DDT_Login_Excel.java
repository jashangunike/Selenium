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
 * @About_This_Class : - Data Driven Testing Using ExcelSheet
 *                   - Here we are passing the userName and password data from Excel
 * @ForMore_Columns : - Pass the parameters in login method, like how many columns you want, like,
 *                  E-mail id, phone number, country etc. you can give parameters
 *                  in login method.. After that
 *                  - go to passdata method, at Object level give columns 4 or 5 etc..
 *                  - Go thru code you can get idea
 * 
 * @TestCase : - Enter username and password click
 *           - if username and password is correct then display - user is able to login otherwise
 *           user is not able to login.
 *
 * 
 */
public class DDT_Login_Excel {
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

	@DataProvider(name = "LoginData")
	public Object[][] passData() {

		ExcelDataConfig obj = new ExcelDataConfig("./src/data_Driven/DataDrivenTestData.xlsx", "Sheet1");

		int rows = obj.getRowCount("Sheet1");

		Object[][] data = new Object[rows][2]; // Rows , 2 columns, For more columns, pass the parameters in login method and change columns here

		for (int i = 0; i < rows; i++) {

			data[i][0] = obj.getExcelData("Sheet1", i, 0);
			data[i][1] = obj.getExcelData("Sheet1", i, 1);
		}

		return data;
	}

}
