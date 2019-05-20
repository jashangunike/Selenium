package data_Driven;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author Dinesh Reddy
 *         About this class : - Excel data reading ( old version of Excel )
 *         - Here we are using reusable method, to call this method and read data from Excel Sheet.
 *
 */
public class ReadExcel_xls {

	public String readExcel(String sheetName, int rowNum, int ColumnNum) {
		String data = null;
		try {
			File src = new File("X:\\Testing\\Workspace\\Selenium_prac\\src\\data_Driven\\ReadExcel_Old.xls");
			Workbook wb = Workbook.getWorkbook(src);
			data = wb.getSheet(sheetName).getCell(rowNum, ColumnNum).getContents();
			// System.out.println(data); // if you comment this then use syso in main method
			//other wise its not display in console
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public int getRowNum(String Sheetname) {

		int rowN = 0;
		try {
			File src = new File("X:\\Testing\\Workspace\\Selenium_prac\\src\\data_Driven\\ReadExcel_Old.xls");
			Workbook wb = Workbook.getWorkbook(src);
			rowN = wb.getSheet(Sheetname).getRows();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rowN;
	}

	public static void main(String[] args) {

		ReadExcel_xls obj = new ReadExcel_xls();

		// the below one is not display in console, because we didn't give syso in reusable method
		// if you want to read without syso then uncomment syso in reusable method
		obj.readExcel("Sheet1", 1, 1);

		// Get Excel data 
		System.out.println(obj.readExcel("Sheet1", 0, 0));

		// row count 
		System.out.println(obj.getRowNum("Sheet1"));

	}

}
