package data_Driven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Dinesh Reddy
 * 
 *         About This class: - Reusable methods to read Excel data
 *         - here we used constructor
 *
 */
public class ExcelDataConfig {

	public XSSFWorkbook wb;
	public XSSFSheet sheet;

	public ExcelDataConfig(String Excelpath, String SheetName) {

		try {
			File src = new File(Excelpath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(SheetName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getExcelData(String SheetName, int rownum, int columnNum) {

		String data = sheet.getRow(rownum).getCell(columnNum).getStringCellValue();
		return data;
	}

	public int getRowCount(String SheetName) {

		int row = wb.getSheet(SheetName).getLastRowNum();

		// row = row+1; // whatever count it will return, it will say +1, Because we need the count not the index.

		return row;
	}

}
