package com.thunsaker.javapin.classes;

import org.json.JSONException;
import org.json.JSONObject;

public class Image implements IJsonParsable {
	private String MobileUrl;
	public String getMobileUrl(){
		return this.MobileUrl;
	}
	public void setMobileUrl(String MobileUrl){
		this.MobileUrl = MobileUrl;
	}
	
	private String CloseupUrl;
	public String getCloseupUrl(){
		return this.CloseupUrl;
	}
	public void setCloseupUrl(String CloseupUrl){
		this.CloseupUrl = CloseupUrl;
	}
	
	private String ThumbnailUrl;
	public String getThumbnailUrl(){
		return this.ThumbnailUrl;
	}
	public void setThumbnailUrl(String ThumbnailUrl){
		this.ThumbnailUrl = ThumbnailUrl;
	}
	
	private String BoardUrl;
	public String getBoardUrl(){
		return this.BoardUrl;
	}
	public void setBoardUrl(String BoardUrl){
		this.BoardUrl = BoardUrl;
	}

	public Image Parse(String JsonStringToParse) {
		try {
    		JSONObject jObject = new JSONObject(JsonStringToParse);
    		Image myImage = new Image();
			return myImage.Parse(jObject);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	public Image Parse(JSONObject JsonObjectToParse) throws JSONException {
		Image myImage = new Image();
		if(JsonObjectToParse.has("mobile"))
			myImage.setMobileUrl(JsonObjectToParse.getString("mobile"));
		if(JsonObjectToParse.has("closeup"))
			myImage.setCloseupUrl(JsonObjectToParse.getString("closeup"));
		if(JsonObjectToParse.has("thumbnail"))
			myImage.setThumbnailUrl(JsonObjectToParse.getString("thumbnail"));
		if(JsonObjectToParse.has("board"))
			myImage.setBoardUrl(JsonObjectToParse.getString("board"));
		return myImage;
	}
}
