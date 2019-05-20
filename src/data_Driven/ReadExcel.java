package data_Driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {

		File src = new File("./src/data_Driven/ReadExcel.xlsx");
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Sheet1");

		// get data from excel	
		String data0 = sheet.getRow(0).getCell(0).getStringCellValue(); // here cell means - which column
		System.out.println("Data from Excel is :" + data0);

		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());

		//  To Count the Total number of rows 

		int rowcount = sheet.getLastRowNum();
		System.out.println("Total rows in Excel is :" + rowcount);

		// for loop 

		for (int i = 0; i <= rowcount; i++) {
			String FirstColumn_allRows = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(FirstColumn_allRows);

	
			String SecColumn_AllRows = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(SecColumn_AllRows);

		}
		// Close the workbook
		wb.close();
	}

}
