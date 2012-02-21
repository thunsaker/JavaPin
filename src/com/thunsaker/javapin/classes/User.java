package com.thunsaker.javapin.classes;

import org.json.JSONException;
import org.json.JSONObject;

public class User extends Base implements IJsonParsable {
	
	private String ImageUrl;
	public String getImageUrl() {
		return this.ImageUrl;
	}
	public void setImageUrl(String ImageUrl) {
		this.ImageUrl = ImageUrl;
	}
	
	private String ImageUrlLarge;
	public String getImageUrlLarge() {
		return this.ImageUrlLarge;
	}
	public void setImageUrlLarge(String ImageUrlLarge) {
		this.ImageUrlLarge = ImageUrlLarge;
	}
	
	private String FullName;
	public String getFullName() {
		return this.FullName;
	}
	public void setFullName(String FullName) {
		this.FullName = FullName;
	}
	
	private String Username;
	public String getUsername() {
		return this.Username;
	}
	public void setUsername(String Username) {
		this.Username = Username;
	}

	
	public User Parse(String JsonStringToParse) {
		try {
    		JSONObject jObject = new JSONObject(JsonStringToParse);
    		User myUser = new User();
			return myUser.Parse(jObject);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public User Parse(JSONObject JsonObjectToParse) throws JSONException {
		User myUser = new User();
		
		if(JsonObjectToParse.has("id"))
			myUser.setId(JsonObjectToParse.getString("id"));
		if(JsonObjectToParse.has("username"))
			myUser.setUsername(JsonObjectToParse.getString("username"));
		if(JsonObjectToParse.has("full_name"))
			myUser.setFullName(JsonObjectToParse.getString("full_name"));
		if(JsonObjectToParse.has("image_url"))
			myUser.setImageUrl(JsonObjectToParse.getString("image_url"));
		if(JsonObjectToParse.has("image_large_url"))
			myUser.setImageUrlLarge(JsonObjectToParse.getString("image_large_url"));
		return myUser;
	}
}
