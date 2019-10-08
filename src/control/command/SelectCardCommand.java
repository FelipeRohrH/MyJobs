package control.command;

import control.GameController;
import model.cards.Card;

public class SelectCardCommand extends GameFluxCommand{
	
	private int cardIndex;
	private Card selectedCard;
	
	public SelectCardCommand(GameController gc, int cardIndex) {
		super(gc);
		this.cardIndex = cardIndex;
	}

	@Override
	public void execute() {
		Card selectedCard = GameController.getInstance().getCard(cardIndex);
		GameController.getInstance().addToSelectedCard(selectedCard);
		
	}

	@Override
	public void undo() {
		GameController.getInstance().removeSelectedCard();
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
