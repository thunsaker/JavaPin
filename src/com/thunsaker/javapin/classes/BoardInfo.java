package com.thunsaker.javapin.classes;

import org.json.JSONException;
import org.json.JSONObject;


public class BoardInfo extends Base implements IJsonParsable {	
	private String Description;
	public String getDescription(){
		return this.Description;
	}
	public void setDescription(String Description){
		this.Description = Description;
	}
	
	private String UserId;
	public String getUserId(){
		return this.UserId;
	}
	public void setUserId(String UserId){
		this.UserId = UserId;
	}
	
	private String Name;
	public String getName(){
		return this.Name;
	}
	public void setName(String Name){
		this.Name = Name;
	}
	
	private String Url;
	public String getUrl(){
		return this.Url;
	}
	public void setUrl(String Url){
		this.Url = Url;
	}

	public BoardInfo Parse(String JsonStringToParse) {
		try {
    		JSONObject jObject = new JSONObject(JsonStringToParse);
    		BoardInfo myBoardInfo = new BoardInfo();
			return myBoardInfo.Parse(jObject);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	public BoardInfo Parse(JSONObject JsonObjectToParse) throws JSONException {
		BoardInfo myBoardInfo = new BoardInfo();
		if(JsonObjectToParse.has("id"))
			myBoardInfo.setId(JsonObjectToParse.getString("id"));
		if(JsonObjectToParse.has("name"))
			myBoardInfo.setName(JsonObjectToParse.getString("name"));
		if(JsonObjectToParse.has("description"))
			myBoardInfo.setDescription(JsonObjectToParse.getString("description"));
		if(JsonObjectToParse.has("url"))
			myBoardInfo.setUrl(JsonObjectToParse.getString("url"));
		if(JsonObjectToParse.has("user_id"))
			myBoardInfo.setUserId(JsonObjectToParse.getString("user_id"));
		return myBoardInfo;
	}
}
