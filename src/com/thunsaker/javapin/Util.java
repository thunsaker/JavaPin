package com.thunsaker.javapin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Endpoint;

import org.json.JSONObject;

import com.sun.tools.hat.internal.model.JavaObject;

public class Util {
	public static String getRawJson(String url){
    	URL theUrl;
		try {
			theUrl = new URL(url);
    		InputStream response;
			response = theUrl.openStream();
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
	
	public static EndpointStatus GetStatus(String status) {
		EndpointStatus s = new EndpointStatus();
		if(status.contains("success")) {
			s.code = 200;
			s.message = "Success";
		} else if(status.startsWith("4")) {
			s.code = Integer.parseInt(status);
			s.message = "Infomation not found";
		} else if(status.startsWith("5")) {
			s.code = Integer.parseInt(status);
			s.message = "Server unavailable";
		}
		
		return s;
	}
}
