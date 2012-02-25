package com.thunsaker.javapin.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.thunsaker.javapin.EndpointStatus;
import com.thunsaker.javapin.PinterestSettings;
import com.thunsaker.javapin.Util;
import com.thunsaker.javapin.classes.Pin;

public class PopularEndpoint {
	public static EndpointStatus status;
	
	public PopularEndpoint() {
		
	}
	
	public List<Pin> GetPopularPins() throws Exception {
		String popularPinsUrl = PinterestSettings.getBaseUrl() + PinterestSettings.getPopularEndpointUrl();
        String rawJson = Util.getRawJson(popularPinsUrl);
        List<Pin> PopularPins = ParseResponse(rawJson);
        if(PopularPins.size() > 0)
        	return PopularPins;
        
    	return null;
	}
	
	private List<Pin> ParseResponse(String rawJson) {
    	List<Pin> popularPins = new ArrayList<Pin>();
    	
    	try {
    		JSONObject jObject = new JSONObject(rawJson);
    		if(jObject.has("status")) {
				status = Util.GetStatus(jObject.getString("status"));
				
				if(status.code != 200)
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
}
