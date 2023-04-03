package genericLibrary;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {
	public String jSONUtility(String key) throws Throwable {
		FileReader fr=new FileReader(IPathConstant.JSONFILEPATH);
		
		JSONParser jp=new JSONParser();
		Object jobj = jp.parse(fr);
		
		HashMap hp=(HashMap)jobj;
		String value=(String) hp.get(key);
		return value;
		
	}
}
