package com.thunsaker.javapin.classes;

import org.json.JSONException;
import org.json.JSONObject;

public class Size implements IJsonParsable {
	private Integer Width;
	public Integer getWidth(){
		return this.Width;
	}
	public void setWidth(Integer Width){
		this.Width = Width;
	}
	
	private Integer Height;
	public Integer getHeight(){
		return this.Height;
	}
	public void setHeight(Integer Height){
		this.Height = Height;
	}

	public Size Parse(String JsonStringToParse) {
		try {
    		JSONObject jObject = new JSONObject(JsonStringToParse);
    		Size mySize = new Size();
			return mySize.Parse(jObject);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	public Size Parse(JSONObject JsonObjectToParse) throws JSONException {
		Size mySize = new Size();
		if(JsonObjectToParse.has("width"))
			mySize.setHeight(JsonObjectToParse.getInt("width"));
		if(JsonObjectToParse.has("height"))
			mySize.setWidth(JsonObjectToParse.getInt("width"));
		return mySize;
	}
}