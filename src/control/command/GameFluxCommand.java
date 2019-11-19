package control.command;

import control.GameController;

public abstract class GameFluxCommand implements Command{

	protected GameController gc;
	
	public GameFluxCommand(GameController gc) {
		this.gc = gc;
	}

	public abstract void execute();
	public abstract void undo();
	
	
	
}
