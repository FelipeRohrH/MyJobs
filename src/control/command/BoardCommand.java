package control.command;

import model.BoardModel;

public abstract class BoardCommand implements Command{
	
	protected BoardModel bm;
	
	public BoardCommand(BoardModel board) {
		this.bm = board;
	}
	
}
