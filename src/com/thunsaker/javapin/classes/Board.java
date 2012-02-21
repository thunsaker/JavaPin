package com.thunsaker.javapin.classes;

import java.util.List;


public class Board extends Base {
	
	private String Name;
	public String getName(){
		return this.Name;
	}
	public void setName(String Name){
		this.Name = Name;
	}
	
	private List<Pin> Pins;
	public List<Pin> getPins(){
		return this.Pins;
	}
	public void setPins(List<Pin> Pins){
		this.Pins = Pins;
	}
}