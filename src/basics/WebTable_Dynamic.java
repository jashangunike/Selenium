package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.OpenBrowser3;

/**
 * @author Dinesh Reddy
 *         about Class = For webtable or calender
 *         1. in dynamic way - you can use xpath to find the webelements upto the table
 *         2. select the table while using xpath
 *         3. After that type - //td - td means - table data (it will match the all nodes ex- 35 or
 *         40 matches )
 * 
 */
public class WebTable_Dynamic extends OpenBrowser3 {

	@Test
	public void webTableDynamic() throws InterruptedException {

		d.findElement(By.id("datepicker1")).click();

		Thread.sleep(4000);
		List<WebElement> dates = d
				.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//td"));
		//**** 1. select the table while using xpath 
		// 2. After that type - //td - td means - table data (it will match the all nodes ex- 35 or 40)

		int total_nodes = dates.size();
		System.out.println("total nodes/cells are  :" + total_nodes);

		for (int i = 0; i < total_nodes; i++) {
			String dates_loop = dates.get(i).getText();
			//System.out.println("Total cells text are :"+dates_loop);
			// Here we place the condition - which date you want to select just give it, ex- 30
			if (dates_loop.contains("30")) {
				dates.get(i).click();
				break; // breaking the loop here 
			}
		}

	}

	// My code for finding how many rows and columns 
	@Test(enabled = false)
	public void row_column() {
		// Find WebElement
		WebElement htmlTable = d.findElement(By.xpath(""));

		// To Get row count 
		List<WebElement> rows = htmlTable.findElements(By.xpath(""));
		int row_count = rows.size();
		System.out.println("Total rows are :" + row_count);

		// To Get cell count 
		List<WebElement> column = htmlTable.findElements(By.xpath(""));
		int column_count = column.size();
		System.out.println("Total rows are :" + column_count);

	}

	@BeforeClass
	public void url() {
		d.get("https://www.abhibus.com/");
	}
}
