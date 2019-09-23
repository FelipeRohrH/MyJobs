package control.command;

import model.Dice;

public abstract class DiceCommand implements Command{
	
	protected Dice dice;
	
	public DiceCommand(Dice dice) {
		this.dice = dice;
	}
	
}
