package Generic.FileUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String getDataFrompropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./commondata/commondata.properties");
		Properties pr = new Properties();
		pr.load(fis);
		String data = pr.getProperty(key);
		return data;
	}
}
