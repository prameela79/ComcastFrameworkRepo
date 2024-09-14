package Practice_Reports;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class sampleTest {
	@Test
	public void sampletest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start",false);
		Reporter.log("step-1",false);
		Reporter.log("step-2",false);
		Reporter.log("step-3",false);
		Reporter.log(mtd.getName()+"ENDS Start",true);
	}
	@Test
	public void sampletest1(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start",true);
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
		Reporter.log(mtd.getName()+"Ends test",true);
	}

}
