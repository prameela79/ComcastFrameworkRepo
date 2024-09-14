
package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadentirerowDatafromExcel {

	public static void main(String[] args) throws Throwable {
		//step1 : get the java object of physical file
				FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\scriptdata\\testscriptdata.xlsx");//get java object physical file
				//step 2: open the work book in read mode
				Workbook wb = WorkbookFactory.create(fis);//open workbook
				//step 3 : get the control of the sheet
				Sheet sh = wb.getSheet("Sheet2");
				//step 4: get the control of row
				Row row = sh.getRow(1);
				for(int i=0;i<=row.getLastCellNum();i++) {
					String data ="";
					try {
					 data  = row.getCell(i).getStringCellValue();
					}catch(Exception e) {}
					//String data = row.getCell(0).getStringCellValue();
					System.out.println(data);
				}
				//System.out.println(data);
			
				 wb.close();

	}

}
