
package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readmultipledatafromexcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\scriptdata\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		for(int i=0;i<=sh.getLastRowNum();i++) {
			String data ="";
			Row row = sh.getRow(i);
			try {
			 data = row.getCell(0).toString();
			}
			catch(Exception e) {}
			 System.out.println(data);
		}
		
	}

}
