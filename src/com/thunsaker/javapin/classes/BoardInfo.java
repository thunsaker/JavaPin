package com.thunsaker.javapin.classes;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
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
	
	private String Category;
	public String getCategory(){
		return this.Category;
	}
	public void setCategory(String Category){
		this.Category = Category;
	}
	
	private Boolean IsCollaborator;
	public Boolean getIsCollaborator(){
		return this.IsCollaborator;
	}
	public void setIsCollaborator(Boolean IsCollaborator){
		this.IsCollaborator = IsCollaborator;
	}
	
	private Boolean IsFollowing;
	public Boolean getIsFollowing(){
		return this.IsFollowing;
	}
	public void setIsFollowing(Boolean IsFollowing){
		this.IsFollowing = IsFollowing;
	}
	
	private List<String> Thumbnails;
	public List<String> getThumbnails(){
		return this.Thumbnails;
	}
	public void setThumbnails(List<String> Thumbnails){
		this.Thumbnails = Thumbnails;
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
		if(JsonObjectToParse.has("category"))
			myBoardInfo.setCategory(JsonObjectToParse.getString("category"));
		if(JsonObjectToParse.has("is_collaborator"))
			myBoardInfo.setIsCollaborator(JsonObjectToParse.getBoolean("is_collaborator"));
		if(JsonObjectToParse.has("is_following"))
			myBoardInfo.setIsFollowing(JsonObjectToParse.getBoolean("is_following"));
		if(JsonObjectToParse.has("thumbnails")) {
			JSONArray thumbArray = JsonObjectToParse.getJSONArray("thumbnails");
			List<String> myThumbs = new ArrayList<String>();
			
			for(int i=0; i < thumbArray.length(); i++) {
				myThumbs.add(thumbArray.getString(i));
			}
			myBoardInfo.setThumbnails(myThumbs);
		}
		return myBoardInfo;
	}
}
