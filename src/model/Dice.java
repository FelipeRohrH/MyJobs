package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Dice {

	private String type;
	private int value;
	
	private String[] possibleTypes = { "Daimyo", // 0
			"Infantry1", // 1
			"Infantry2", // 2
			"Infantry3", // 3
			"Archery", // 4
			"Cavalry" // 5
	};
	private Icon icon;

	public Dice(String type) {
		this.type = type;
		setIcon();
	}

	public void setType(int index) {
		this.type = this.possibleTypes[index];
		setIcon();
	}

	public String getType() {
		return this.type;
	}

	public Icon getIcon() {
		return this.icon;
	}

	public void setIcon() {
		this.icon = new ImageIcon("images/troops/" + getType() + ".png");
	}

	public int getValue() {
		int value = 0;
		switch (getType()) {
		case "Infantry2":
			value = 2;
			return value;
		case "Infantry3":
			value = 3;
			return value;
		default:
			value = 1;
			return value;
		}

	}

}