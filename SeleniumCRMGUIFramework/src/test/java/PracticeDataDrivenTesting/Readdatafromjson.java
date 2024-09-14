package PracticeDataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Readdatafromjson {

	public static void main(String[] args) throws Throwable {
		//step1: get the java object of physical json file
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\HP\\Desktop\\commdata\\appcommondata.json"));
		//step2 convert java object into json object
		JSONObject map = (JSONObject)obj;
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		

	}

}
