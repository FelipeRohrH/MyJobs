package model;

import java.util.Random;

public class Dice {
	
	//0, 1, 2, 3, 4, 5
	private String[] values = {  
								"Daimyo",  	 //0
							    "Infantry1", //1
							    "Infantry2", //2
							    "Infantry3", //3
							    "Archery", 	 //4
							  	"Cavalry"	 //5
							 };
	private Random randomValue;
	
	public Dice() {
		randomValue = new Random();
	}
	
	public String getDiceValue() {
		return this.values[randomValue.nextInt(6)];
	}
	
}