package com.thunsaker.javapin.classes;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Comment implements IJsonParsable {
	private String Text;
	public String getText(){
		return this.Text;
	}
	public void setText(String Text){
		this.Text = Text;
	}
	
	private User User;
	public User getUser(){
		return this.User;
	}
	public void setUser(User User){
		this.User = User;
	}
	
	public Comment Parse(String JsonStringToParse) {
		try {
    		JSONObject jObject = new JSONObject(JsonStringToParse);
    		Comment myComment = new Comment();
			return myComment.Parse(jObject);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Comment Parse(JSONObject JsonObjectToParse) throws JSONException {
		Comment myComment = new Comment();
		if(JsonObjectToParse.has("text"))
			myComment.setText(JsonObjectToParse.getString("text"));
		if(JsonObjectToParse.has("user")) {
			User myUser = new User();
			myComment.setUser(myUser.Parse(JsonObjectToParse.getJSONObject("user")));
		}
		return myComment;
	}
	
	public List<Comment> Parse(JSONArray JsonArrayToParse) throws JSONException {
		List<Comment> comments = new ArrayList<Comment>();

		for (int i = 0; i < JsonArrayToParse.length(); i++) {
			Comment myComment = new Comment();
			JSONObject pinItem = (JSONObject) JsonArrayToParse.get(i);
			comments.add(myComment.Parse(pinItem));
		}

		return comments;
	}
}
