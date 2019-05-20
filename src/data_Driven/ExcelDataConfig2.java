package data_Driven;


/**
 * @author Dinesh Reddy
 * 
 *  About this Class - Just Reusing ExcelDataConfig Class methods 
 *
 */
public class ExcelDataConfig2 {

	public static void main(String[] args) {

		ExcelDataConfig obj = new ExcelDataConfig("./src/data_Driven/ReadExcel.xlsx", "Sheet1");
		System.out.println(obj.getExcelData("Sheet1", 0, 0));
		System.out.println(obj.getExcelData("Sheet1", 0, 1));
		System.out.println(obj.getExcelData("Sheet1", 1, 0));

	}

}
