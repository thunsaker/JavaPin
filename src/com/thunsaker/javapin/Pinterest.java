package com.thunsaker.javapin;

import java.util.List;

import com.thunsaker.javapin.classes.Pin;
import com.thunsaker.javapin.classes.User;
import com.thunsaker.javapin.endpoints.PopularEndpoint;
import com.thunsaker.javapin.endpoints.UserEndpoint;

public class Pinterest {
	public Pinterest(){ }
	
	public static List<Pin> PopularPins() throws Exception {
		PopularEndpoint popular = new PopularEndpoint();
		return popular.GetPopularPins();
	}
	
	public static User UserInfo(String Username) throws Exception {
		UserEndpoint user = new UserEndpoint();
		return user.GetUser(Username);
	}
}
