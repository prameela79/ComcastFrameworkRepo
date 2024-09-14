package Practice_Screenshot;

import java.util.Date;

public class TimeBasedScreenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//use this in listener implementation class of ontestfailure method
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(time);

	}

}
