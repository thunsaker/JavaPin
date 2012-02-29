package com.thunsaker.javapin.classes;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.json.JSONArray;
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
	
	private Boolean IsFollowing;
	public Boolean getIsFollowing() {
		return this.IsFollowing;
	}
	public void setIsFollowing(Boolean IsFollowing) {
		this.IsFollowing = IsFollowing;
	}
	
	private String Location;
	public String getLocation() {
		return this.Location;
	}
	public void setLocation(String Location) {
		this.Location = Location;
	}
	
	private String About;
	public String getAbout() {
		return this.About;
	}
	public void setAbout(String About) {
		this.About = About;
	}
	
	private String Website;
	public String getWebsite() {
		return this.Website;
	}
	public void setWebsite(String Website) {
		this.Website = Website;
	}
	
	private String TwitterLink;
	public String getTwitterLink() {
		return this.TwitterLink;
	}
	public void setTwitterLink(String TwitterLink) {
		this.TwitterLink = TwitterLink;
	}
	
	private String FacebookLink;
	public String getFacebookLink() {
		return this.FacebookLink;
	}
	public void setFacebookLink(String FacebookLink) {
		this.FacebookLink = FacebookLink;
	}

	private Hashtable<String, Integer> Stats;
	public Hashtable<String, Integer> getStats(){
		return this.Stats;
	}
	public void setStats(Hashtable<String, Integer> Stats){
		this.Stats = Stats;
	}
	
	private List<BoardInfo> Boards;
	public List<BoardInfo> getBoards(){
		return this.Boards;
	}
	public void setBoards(List<BoardInfo> Boards){
		this.Boards = Boards;
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
		if(JsonObjectToParse.has("website"))
			myUser.setWebsite(JsonObjectToParse.getString("website"));
		if(JsonObjectToParse.has("about"))
			myUser.setAbout(JsonObjectToParse.getString("about"));
		if(JsonObjectToParse.has("twitter_link"))
			myUser.setTwitterLink(JsonObjectToParse.getString("twitter_link"));
		if(JsonObjectToParse.has("facebook_link"))
			myUser.setFacebookLink(JsonObjectToParse.getString("facebook_link"));
		if(JsonObjectToParse.has("location"))
			myUser.setLocation(JsonObjectToParse.getString("location"));
		if(JsonObjectToParse.has("is_following") && !JsonObjectToParse.isNull("is_following") && JsonObjectToParse.getString("is_following") != "null")
			myUser.setIsFollowing(JsonObjectToParse.getBoolean("is_following"));
		if(JsonObjectToParse.has("stats")) {
			Hashtable<String, Integer> myStats = new Hashtable<String, Integer>();
			JSONObject StatsJObject = JsonObjectToParse.getJSONObject("stats");
			if(StatsJObject.has("followers_count"))
				myStats.put("Followers", StatsJObject.getInt("followers_count"));
			if(StatsJObject.has("likes_count"))
				myStats.put("Likes", StatsJObject.getInt("likes_count"));
			if(StatsJObject.has("pins_count"))
				myStats.put("Pins", StatsJObject.getInt("pins_count"));
			if(StatsJObject.has("following_count"))
				myStats.put("Following", StatsJObject.getInt("following_count"));
			if(StatsJObject.has("boards_count"))
				myStats.put("Boards", StatsJObject.getInt("boards_count"));
			myUser.setStats(myStats);
		}
		if(JsonObjectToParse.has("boards")) {
			List<BoardInfo> myBoards = new ArrayList<BoardInfo>();
			// Contemplate putting this into the BoardInfo class
			JSONArray jBoards = JsonObjectToParse.getJSONArray("boards");
			
			for(int i= 0; i < jBoards.length(); i++) {
				BoardInfo myBoardInfo = new BoardInfo();
				JSONObject boardItem = (JSONObject) jBoards.get(i);
				myBoards.add(myBoardInfo.Parse(boardItem));
			}
			myUser.setBoards(myBoards);
		}
		return myUser;
	}
}
