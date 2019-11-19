package control.command;

import control.GameController;

public class SelectCardCommand extends GameFluxCommand{
	
	private int cardIndex;
	
	public SelectCardCommand(GameController gc, int index) {
		super(gc);
		this.cardIndex = index;
	}

	@Override
	public void execute() {
		gc.addToCardStack(gc.getCard(cardIndex));
//		System.out.println(gc.getCard(cardIndex).toString());
		
	}

	@Override
	public void undo() {
		gc.removeFromCardStack();
		
	}


}
