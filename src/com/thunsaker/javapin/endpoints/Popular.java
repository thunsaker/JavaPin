package com.thunsaker.javapin.endpoints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.thunsaker.javapin.PinterestSettings;
import com.thunsaker.javapin.classes.Pin;

public class Popular {
	public static String status = "";
	
	public static List<Pin> getPopularPins(){
        String rawJson = getPopularPinsRawJson();
        List<Pin> PopularPins = parsePopularPinsRawJson(rawJson);
        if(PopularPins.size() > 0)
        	return PopularPins;
        
    	return null;
	}
	
	private static List<Pin> parsePopularPinsRawJson(String rawJson) {
    	List<Pin> popularPins = new ArrayList<Pin>();
    	
    	try {
    		JSONObject jObject = new JSONObject(rawJson);
    		if(jObject.has("status")) {
    			status = jObject.getString("status");
    			if(status.startsWith("4") || status.startsWith("5"))
    				return null;
    			
    			// Add logic for handling other status codes
    		}
    		
			JSONArray jPins = jObject.getJSONArray("pins");
			
			for (int i = 0; i < jPins.length(); i++) {
				Pin myPin = new Pin();
				//JsonObject pinItem = jPins.get(i);
				JSONObject pinItem = (JSONObject) jPins.get(i);
				if(pinItem.has("id"))
					myPin = myPin.Parse(pinItem);
				
				popularPins.add(myPin);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return popularPins != null && popularPins.size() > 0 ? popularPins : new ArrayList<Pin>();
	}

	private static String getPopularPinsRawJson(){
    	URL popularUri;
		try {
			popularUri = new URL(PinterestSettings.getBaseUrl() + PinterestSettings.getPopularEndpoint());
    		InputStream response;
			response = popularUri.openStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response));
			List<String> rawJson = new ArrayList<String>();
			
			for(String line; (line = bufferedReader.readLine()) != null;) {
				rawJson.add(line);
			}
			
			bufferedReader.close();
			
			return rawJson.get(0);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return null;
    }
}
