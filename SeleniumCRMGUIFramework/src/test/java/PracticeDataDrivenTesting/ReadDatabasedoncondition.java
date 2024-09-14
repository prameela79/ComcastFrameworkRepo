 package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatabasedoncondition {

	public static void main(String[] args) throws Throwable {
		String data1 ="";
		String data2 ="";
		String data3 ="";
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\scriptdata\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		
		String expcond = "TC_02";
		int rowcount = sh.getLastRowNum();
		for(int i=1;i<=rowcount;i++) {
			String data ="";
			try {
			data = sh.getRow(i).getCell(0).toString();
			if(data.equals(expcond)) {
				data1 = sh.getRow(i).getCell(1).toString();
				data2 = sh.getRow(i).getCell(2).toString();
				data3 = sh.getRow(i).getCell(3).toString();
			}
			}
			catch(Exception e) {}
		}
	
	System.out.println(data1);
	System.out.println(data2);
	System.out.println(data3);

}
}

