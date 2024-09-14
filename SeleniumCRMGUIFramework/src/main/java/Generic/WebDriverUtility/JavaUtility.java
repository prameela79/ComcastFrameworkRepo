package Generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNum() {
		Random random = new Random();
		int randomint = random.nextInt(1000);
		return randomint;
	}
	public String getSystemdate() {
		Date dateobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
		return date;
	}
	
	//required date method
	public String getRequiredDate(int days) {
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR,days);
		String reqdate = sim.format(cal.getTime());
		
		return reqdate;
	}

}
