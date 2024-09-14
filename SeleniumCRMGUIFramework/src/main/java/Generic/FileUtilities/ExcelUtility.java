
package Generic.FileUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	//Read data from excel file
	public String getDataFromExcelFile(String sheetName, int rowNum, int celNum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./Testdata/Scriptdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).toString();
		return data;
	}
	//Get row count from excel file
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./Testdata/Scriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}
	//Write data into Excel file
	public void SetDataIntoExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./Testdata/Scriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		FileOutputStream fos = new FileOutputStream("./Testdata/Scriptdata.xlsx");
		wb.write(fos);
		wb.close();
		}

}
