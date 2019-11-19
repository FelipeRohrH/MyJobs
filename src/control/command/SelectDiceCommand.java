package control.command;

import control.GameController;

public class SelectDiceCommand extends GameFluxCommand{
	
	private int diceIndex;
	
	public SelectDiceCommand(GameController gc, int index) {
		super(gc);
		this.diceIndex = index;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void execute() {
//		gc.addToDiceQueue(gc.getDice(diceIndex));
//		
//	}
//
//	@Override
//	public void undo() {
//		gc.removeFromDiceQueue(gc.getDice(diceIndex));
//		System.out.println("removido" + gc.getDiceQueue().size());
//		
//	}


}
