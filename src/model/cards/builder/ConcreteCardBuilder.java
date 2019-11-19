package model.cards.builder;

import model.Guild;
import model.battleLines.builder.BattleLine;

public class ConcreteCardBuilder extends CardBuilder{

	private Card card;
	
	@Override
	public Card getCard() {
		return this.card;
	}
	
	@Override
	public void reset() {
		this.card = new Card();
		
	}

	@Override
	public void buildName(String cardName) {
		card.setCardName(cardName);
		
	}

	@Override
	public void buildPoints(int points) {
		card.setCardPoints(points);
		
	}

	@Override
	public void buildGuid(Guild guild) {
		card.setGuild(guild);
	}

	@Override
	public void buildBLines(BattleLine[] bl) {
		card.setBl(bl);
		
	}

	@Override
	public void buildIcon() {
		this.card.setIcon();
	}
	
	@Override
	public void buildDaimyo(boolean daimyo) {
		this.card.setHasDaimyo(daimyo);
	}
	
	
}
