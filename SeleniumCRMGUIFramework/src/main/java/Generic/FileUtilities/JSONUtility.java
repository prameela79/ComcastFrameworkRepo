package Generic.FileUtilities;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	public String getDataFromJSONFile(String key) throws Throwable, ParseException {
		FileReader fir = new FileReader("./commondata/appcommondata.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fir);
		JSONObject map = (JSONObject)obj;
		String data = (String) map.get(key);
		return data;
	}

}
