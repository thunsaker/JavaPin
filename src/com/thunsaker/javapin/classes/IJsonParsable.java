package com.thunsaker.javapin.classes;

import org.json.JSONException;
import org.json.JSONObject;

public interface IJsonParsable {
	public Object Parse(String JsonStringToParse);
	
	public Object Parse(JSONObject JsonObjectToParse) throws JSONException;
}
