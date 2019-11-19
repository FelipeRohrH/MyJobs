package model.battleLines.builder;

public class BattleLine {

	private String[] troops;
	private int lineValue;
	

	public BattleLine(String[] troops, int lineValue) {
		super();
		this.troops = troops;
		this.lineValue = lineValue;
	}

	public String[] getTroops() {
		return troops;
	}
	
	public void setTroops(String[] t) {
		this.troops = t;
	}

	public void setLineValue(int value) {
		this.lineValue = value;
	}

	public int getLineValue() {
		return lineValue;
	}

}
