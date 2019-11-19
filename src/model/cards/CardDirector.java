package model.cards;

import model.Guild;
import model.battleLines.builder.BattleLine;
import model.cards.builder.CardBuilder;

public class CardDirector {
	
	private CardBuilder b;

	public CardDirector(CardBuilder cardBuilder) {
		this.b = cardBuilder;
	}
	
	public void build(String name, int points, Guild guild, BattleLine[] bl, boolean daimyo) {
		b.reset();
		
		b.buildName(name);
		b.buildPoints(points);
		b.buildGuid(guild);
		b.buildBLines(bl);
		b.buildIcon();
		b.buildDaimyo(daimyo);
	}
	
}
