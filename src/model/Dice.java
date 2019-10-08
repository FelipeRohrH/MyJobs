package model;

public class Dice {
	//0, 1, 2, 3, 4, 5
	private String value;
	
	private String[] possibleValues = {  
								"Daimyo",  	 //0
							    "Infantry1", //1
							    "Infantry2", //2
							    "Infantry3", //3
							    "Archery", 	 //4
							  	"Cavalry"	 //5
							 };
	
	public Dice() {
		
	}
	
	public String setValue(int index) {
		return this.value = this.possibleValues[index];
	}
	
	public String getValue() {
		return this.value;
	}

	
}