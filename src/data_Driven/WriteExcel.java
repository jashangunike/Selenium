package data_Driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Dinesh Reddy
 * 
 *         About This Class :- Write data to the Excel Sheet, Like Result pass or fail
 *         - File name - Write Excel, already rows and columns are exists in these excel sheet so we
 *         are writing the data from 3rd column from 2nd row onwards - is nothing but, 2nd row - 1st
 *         index,3rd column - 2nd index.
 * @info - Every row and column in Excel starts from 0 index.
 *       - Before writing to Excel sheet, make sure to close the Excel, because may be it will
 *       corrupt the excel or throw error.
 *
 */
public class WriteExcel {

	public static void main(String[] args) throws IOException {

		File src = new File("X:\\Testing\\Workspace\\Selenium_prac\\src\\data_Driven\\WriteExcel.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		// Enter data in to the cells 
		sheet.getRow(1).createCell(2).setCellValue("Pass"); // here Create cell - means which column
		sheet.getRow(2).createCell(2).setCellValue("Fail");
		sheet.getRow(3).createCell(2).setCellValue(55);


		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		// Close the workook 
		wb.close();
	}

}
