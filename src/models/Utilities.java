package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Utilities {
	
	public static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
	
	public static String readFile(String path) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(path)));
		
	}
	
	
	public static String prettyJSON(String uglyJSONString) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(uglyJSONString);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}

	
	public static String angloDate2LatinDate(String date) throws ParseException {
		
		SimpleDateFormat sFrom = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat sTo = new SimpleDateFormat("dd/MM/yyyy");
		String result = sTo.format(sFrom.parse(date));
		return result;
		
		
	}
	
	
}
