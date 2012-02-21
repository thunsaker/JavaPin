package com.thunsaker.javapin;

import java.util.List;

import com.thunsaker.javapin.classes.Pin;
import com.thunsaker.javapin.endpoints.Popular;

public class Pinterest {
	public Pinterest(){ }
	
	public static List<Pin> PopularPins() {
		return Popular.getPopularPins();
	}
}
