package com.thunsaker.javapin.endpoints;

import org.json.JSONException;
import org.json.JSONObject;

import com.thunsaker.javapin.EndpointStatus;
import com.thunsaker.javapin.PinterestSettings;
import com.thunsaker.javapin.Util;
import com.thunsaker.javapin.classes.User;

public class UserEndpoint {
	public static EndpointStatus status;
	
	public UserEndpoint() {
		
	}
	
	public User GetUser(String Username) throws Exception {
		if(Username != null && Username != "") {
			String userUrl = PinterestSettings.getBaseUrl() + PinterestSettings.getUserEndpointUrl();
			String.format(userUrl, Username);
			String rawJson = Util.getRawJson(userUrl);
			User UserInfo = ParseResponse(rawJson);
			if(UserInfo != null)
				return UserInfo;
		}
		
		return null;
	}
	
	private User ParseResponse(String rawJson) {
		User myUser = new User();
		
		try {
			JSONObject jObject = new JSONObject(rawJson);
			if(jObject.has("status")) {
				status = Util.GetStatus(jObject.getString("status"));
				
				if(status.code != 200)
					return null;
			}
			
			if(jObject.has("user")) {
				myUser = myUser.Parse(jObject.getJSONObject("user"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return myUser != null ? myUser : null;
	}
}