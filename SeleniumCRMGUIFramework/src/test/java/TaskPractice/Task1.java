package TaskPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Task1 {
	public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./commondata/TASKdata.properties");
	Properties pr = new Properties();
	pr.load(fis);
	Set<Object> data = pr.keySet();
	int size = data.size();
	int halfdata = data.size()/2;

	FileInputStream fis1 = new FileInputStream("./Testdata/Scriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh1 = wb.createSheet("sheet1");
	Sheet sh2 = wb.createSheet("sheet2");
	Sheet sh3 = wb.createSheet("sheet3");
	int row1 = 0; 
	int row2 = 0,count=0;
	for(Object key:data) {
	   String value = pr.getProperty((String) key);
	   if(count<halfdata) {
		   sh1.createRow(row1++).createCell(0) .setCellValue(value); 
	   }
	   else {
		   sh2.createRow(row2++).createCell(0).setCellValue(value);
	   }
	   count++;
	   
	}
	FileOutputStream fos = new FileOutputStream("./Testdata/Scriptdata.xlsx");
	wb.write(fos);
	
	//read data from excel sheet 
	 Sheet s = wb.getSheet("sheet1");
	 Sheet s1 = wb.getSheet("sheet2");
	 int rowcount = s.getLastRowNum();
	 int rowcount2 = s1.getLastRowNum();
	 for (int i = 0; i <=rowcount; i++) {
	     String value = s.getRow(i).getCell(0).toString();
	     sh3.createRow(i).createCell(0).setCellValue(value);
	 }
	 for (int j = 0; j <=rowcount2; j++) {
	     String value1 = s1.getRow(j).getCell(0).toString();
	     sh3.createRow(rowcount+1+j).createCell(0).setCellValue(value1);
	 }
	 // Write data to the workbook again after modifications 
	FileOutputStream fosob = new FileOutputStream("./Testdata/Scriptdata.xlsx");
	wb.write(fosob);
	wb.close();
	 }



@Test
public void task() throws Throwable {
	 FileInputStream fis=new FileInputStream("./commondata/TASKdata.properties");
	 Properties pobj=new Properties();
	 pobj.load(fis);
	Set<Object> data=pobj.keySet();
	int size = data.size();
	FileInputStream fis1=new FileInputStream("./Testdata/Scriptdata.xlsx");
	Workbook wb=WorkbookFactory.create(fis1);
	Sheet sheet1 = wb.createSheet("a");
	Sheet sheet2 = wb.createSheet("b");
	Sheet sheet3 = wb.createSheet("c");
	
	int n=0; int row1=0;int row2=0;
	for (Object key : data)
	{
		n++;
		String value = pobj.getProperty((String) key);
		if(n<=size/2)
		{
			sheet1.createRow(row1++).createCell(0).setCellValue(value);
		}else
		{
			sheet2.createRow(row2++).createCell(0).setCellValue(value);

		}
	}
	FileOutputStream fout = new FileOutputStream("./Testdata/Scriptdata.xlsx");
	wb.write(fout);
	
	int length=sheet1.getLastRowNum()+sheet2.getLastRowNum();
	for (int i = 0,a=0,b=0 ;i < length; i++)
	{
		if(i<sheet1.getLastRowNum())
		{
			sheet3.createRow(i).createCell(0).setCellValue(sheet1.getRow(a++).getCell(0).getStringCellValue());
		}else
		{
			sheet3.createRow(i).createCell(0).setCellValue(sheet2.getRow(b++).getCell(0).getStringCellValue());

		}
	}
	FileOutputStream fout1 = new FileOutputStream("./Testdata/Scriptdata.xlsx");
	wb.write(fout1);

 }

	
}

















