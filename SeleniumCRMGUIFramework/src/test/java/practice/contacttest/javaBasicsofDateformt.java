
package practice.contacttest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class javaBasicsofDateformt {

	public static void main(String[] args) {
		Date dateobj = new Date();//CURRENT DATE
		//convert for required format
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		 String actdate = sim.format(dateobj);
		 System.out.println(actdate);
		 //before 30 days date
		 Calendar cal = sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH,30);
		 String dateRequired = sim.format(cal.getTime());
		 System.out.println(dateRequired);
		 
		 
		

	}

}
