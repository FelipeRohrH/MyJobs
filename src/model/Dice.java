package model;

public class Dice {
	//0, 1, 2, 3, 4, 5
	private String diceValue;
	
	private String[] possibleValues = {  
								"Daimyo",  	 //0
							    "Infantry1", //1
							    "Infantry2", //2
							    "Infantry3", //3
							    "Archery", 	 //4
							  	"Cavalry"	 //5
							 };
	
	public Dice() {
		this.diceValue = "?";
	}
	
	public String rollDiceValue(int index) {
		return this.diceValue = this.possibleValues[index];
	}
	
	public String getValue() {
		return this.diceValue;
	}

	
}