
package PracticeDataDrivenTesting;

import org.testng.annotations.Test;

public class readruntimemavenparameter {
	@Test
	public void runtimemavenparameter() {
		String url =System.getProperty("url");
		System.out.println("env data-->url-->"+url);
	}

}
