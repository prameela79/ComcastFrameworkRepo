package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class property {

	public static void main(String[] args) throws Throwable   {
		//step1: get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\commondata.properties");
		
		//step2:using property class load all the keys
         Properties p = new	Properties();
         p.load(fis);

		//step3: get the value based on key
         System.out.println(p.getProperty("url"));
		

	}

}
