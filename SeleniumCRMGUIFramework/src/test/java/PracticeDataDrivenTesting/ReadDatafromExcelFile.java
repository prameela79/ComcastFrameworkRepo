package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatafromExcelFile {

	public static void main(String[] args) throws Throwable {
		//step1 : get the java object of physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\scriptdata\\testscriptdata.xlsx");//get java object physical file
		//step 2: open the work book in read mode
		Workbook wb = WorkbookFactory.create(fis);//open workbook
		//step 3 : get the control of the sheet
		Sheet sh = wb.getSheet("org");//it return object of sheet so receive the object
		//step 4: get the control of row
		 Row row = sh.getRow(1);
		 //step5: get the control of cell
		 String data = row.getCell(3).getStringCellValue();
		// String data = cell.getStringCellValue();
		 System.out.println(data);
		 wb.close();
		
		

	}

}
