package com.thunsaker.javapin;

public class PinterestSettings {
	// Enter your settings in this class
	// Register for an API key: http://pinterest.com/developers/applications/new/
	
	private static String ApplicationId = "YOUR_APPLICATION_ID";
	public static String getApplicationId() {
		return ApplicationId;
	}
	
	private static String ClientSecret = "YOUR_SECRET";
	public static String getClientSecret() {
		return ClientSecret;
	}
	
	private static String CallbackUrl = "YOUR_CALLBACK_URL";
	public static String getCallbackUrl() {
		return CallbackUrl;
	}
	
	
	private static String BaseUrl = "https://api.pinterest.com/v2/";
	public static String getBaseUrl() {
		return BaseUrl;
	}
	
	private static String PopularEndpoint = "popular/";
	public static String getPopularEndpoint() {
		return PopularEndpoint;
	}
}
