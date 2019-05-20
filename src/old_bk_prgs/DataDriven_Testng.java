package old_bk_prgs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDriven_Testng {

	WebDriver d;

	@Test(dataProvider = "testdata")
	public void login(String username, String password) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// launch website and 
		d.get("https://www.facebook.com");
		d.findElement(By.id("email")).sendKeys(username);
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		d.findElement(By.id("pass")).sendKeys(password);
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		d.findElement(By.xpath("//input[@id='u_0_2'][@type='submit']")).click();
		
		// get the entered values from data provider for my confirmation
		

		// give the verification point here
		// Assert.assertEquals("actual", "expected");
		d.close();
	}

	@DataProvider(name = "testdata")
	public Object[][] readExcel() throws BiffException, IOException  {

		File f = new File("X:\\Testing\\Workspace\\Selenium_prac\\src\\book_prgs\\TestData.xls");
		Workbook w = Workbook.getWorkbook(f);
		Sheet s = w.getSheet("Sheet1");

		int rows = s.getRows();
		int columns = s.getColumns();

		// To print rows and columns 
		System.out.println("Rows are : " + rows);
		System.out.println("Columns are :" + columns);

		String inputData[][] = new String[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell c = s.getCell(j, i);
				inputData[i][j] = c.getContents();
				System.out.println(inputData[i][j]);
			}
		}

		return inputData;

	}

}
