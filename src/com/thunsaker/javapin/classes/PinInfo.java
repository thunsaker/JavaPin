package com.thunsaker.javapin.classes;

import java.util.Hashtable;

import org.json.JSONException;
import org.json.JSONObject;

public class PinInfo implements IJsonParsable {	
	private String Domain;
	public String getDomain(){
		return this.Domain;
	}
	public void setDomain(String Domain){
		this.Domain = Domain;
	}
	
	private String Description;
	public String getDescription(){
		return this.Description;
	}
	public void setDescription(String Description){
		this.Description = Description;
	}
	
	private User User;
	public User getUser(){
		return this.User;
	}
	public void setUser(User User){
		this.User = User;
	}
	
	private Hashtable<String, Integer> Counts;
	public Hashtable<String, Integer> getCounts(){
		return this.Counts;
	}
	public void setCounts(Hashtable<String, Integer> Counts){
		this.Counts = Counts;
	}
	
	private String CreatedAt;
	public String getCreatedAt(){
		return this.CreatedAt;
	}
	public void setCreatedAt(String CreatedAt){
		this.CreatedAt = CreatedAt;
	}
	
	private String SourceUrl;
	public String getSourceUrl(){
		return this.SourceUrl;
	}
	public void setSourceUrl(String SourceUrl){
		this.SourceUrl = SourceUrl;
	}
	
	private Boolean IsRepin;
	public Boolean getIsRepin(){
		return this.IsRepin;
	}
	public void setIsRepin(Boolean IsRepin){
		this.IsRepin = IsRepin;
	}
	
	private Boolean IsVideo;
	public Boolean getIsVideo(){
		return this.IsVideo;
	}
	public void setIsVideo(Boolean IsVideo){
		this.IsVideo = IsVideo;
	}

	public PinInfo Parse(String JsonStringToParse) {
		try {
    		JSONObject jObject = new JSONObject(JsonStringToParse);
    		PinInfo myPin = new PinInfo();
			return myPin.Parse(jObject);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	public PinInfo Parse(JSONObject JsonObjectToParse) throws JSONException {
		PinInfo myPin = new PinInfo();
		if(JsonObjectToParse.has("domain"))
			myPin.setDomain(JsonObjectToParse.getString("domain"));
		if(JsonObjectToParse.has("description"))
			myPin.setDescription(JsonObjectToParse.getString("description"));
		if(JsonObjectToParse.has("counts")) {
			Hashtable<String, Integer> myCounts = new Hashtable<String, Integer>();
			JSONObject CountsJObject = JsonObjectToParse.getJSONObject("counts");
			if(CountsJObject.has("repins"))
				myCounts.put("Repins", CountsJObject.getInt("repins"));
			if(CountsJObject.has("comments"))
				myCounts.put("Comments", CountsJObject.getInt("comments"));
			if(CountsJObject.has("likes"))
				myCounts.put("Likes", CountsJObject.getInt("likes"));
			myPin.setCounts(myCounts);
		}
		if(JsonObjectToParse.has("created_at"))
			myPin.setCreatedAt(JsonObjectToParse.getString("created_at"));
		if(JsonObjectToParse.has("is_repin") && !JsonObjectToParse.isNull("is_repin") && JsonObjectToParse.getString("is_repin") != "null")
			myPin.setIsRepin(JsonObjectToParse.getBoolean("is_repin"));
		if(JsonObjectToParse.has("is_video") && !JsonObjectToParse.isNull("is_video") && JsonObjectToParse.getString("is_video") != "null")
			myPin.setIsVideo(JsonObjectToParse.getBoolean("is_video"));
		if(JsonObjectToParse.has("source"))
			myPin.setSourceUrl(JsonObjectToParse.getString("source"));
		if(JsonObjectToParse.has("user")) {
			User myUser = new User();
			myPin.setUser(myUser.Parse(JsonObjectToParse.getJSONObject("user")));
		}
		return myPin;
	}
}
