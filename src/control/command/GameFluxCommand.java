package control.command;

import java.util.ArrayList;
import java.util.List;

import control.GameController;
import model.cards.Card;

public abstract class GameFluxCommand implements Command{

	private GameController gc;
	
	public GameFluxCommand(GameController gc) {
		super();
		this.gc = gc;
	}

	public abstract void execute();
	public abstract void undo();
	public abstract void redo();
	
	
	
}
