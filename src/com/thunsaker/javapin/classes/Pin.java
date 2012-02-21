package com.thunsaker.javapin.classes;

import java.util.Hashtable;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Pin extends Base implements IJsonParsable {
	private PinInfo PinInfo;
	public PinInfo getPinInfo() {
		return this.PinInfo;
	}
	public void setPinInfo(PinInfo PinInfo) {
		this.PinInfo = PinInfo;
	}
	
	private Image Image;
	public Image getImage() {
		return this.Image;
	}
	public void setImage(Image Image) {
		this.Image = Image;
	}
	
	private Hashtable<String, Size> Sizes;
	public Hashtable<String, Size> getSizes() {
		return this.Sizes;
	}
	public void setSizes(Hashtable<String, Size> Sizes) {
		this.Sizes = Sizes;
	}
	
	private List<Comment> Comments;
	public List<Comment> getComments() {
		return this.Comments;
	}
	public void setComments(List<Comment> Comments) {
		this.Comments = Comments;
	}
	
	private BoardInfo BoardInfo;
	public BoardInfo getBoardInfo() {
		return this.BoardInfo;
	}
	public void setBoardInfo(BoardInfo BoardInfo) {
		this.BoardInfo = BoardInfo;
	}

	public Pin Parse(String JsonStringToParse) {
		try {
    		JSONObject jObject = new JSONObject(JsonStringToParse);
    		Pin myPin = new Pin();
			return myPin.Parse(jObject);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	public Pin Parse(JSONObject JsonObjectToParse) throws JSONException {
		Pin myPin = new Pin();
		if(JsonObjectToParse.has("id")) {
			myPin.setId(JsonObjectToParse.getString("id"));

			// Set Pin Info
			PinInfo myPinInfo = new PinInfo();
			myPin.setPinInfo(myPinInfo.Parse(JsonObjectToParse));
		}

		// Set Board Info
		if(JsonObjectToParse.has("board")) {
			BoardInfo myBoardInfo = new BoardInfo();
			myPin.setBoardInfo(myBoardInfo.Parse(JsonObjectToParse.getJSONObject("board")));
		}

		if(JsonObjectToParse.has("images")) {
			Image myImage = new Image();
			myPin.setImage(myImage.Parse(JsonObjectToParse.getJSONObject("images")));
		}

		if(JsonObjectToParse.has("comments")) {
			JSONArray jsonComments = JsonObjectToParse.getJSONArray("comments");
			Comment myComment = new Comment();
			myPin.setComments(myComment.Parse(jsonComments));
		}

		if(JsonObjectToParse.has("sizes")) {
			Hashtable<String, Size> mySizes = new Hashtable<String, Size>();
			Size mySize = new Size();
			if(JsonObjectToParse.getJSONObject("sizes").has("mobile"))
				mySizes.put("mobile", mySize.Parse(JsonObjectToParse.getJSONObject("sizes")));
			if(JsonObjectToParse.getJSONObject("sizes").has("board"))
				mySizes.put("board", mySize.Parse(JsonObjectToParse.getJSONObject("sizes")));
			myPin.setSizes(mySizes);
		}
		return myPin;
	}
}
