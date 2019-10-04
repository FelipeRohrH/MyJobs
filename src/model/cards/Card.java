package model.cards;

import java.util.List;

public class Card{
	
	private Guild guild;
	private BattleLine bl;
	private int cardPoints; 
	private boolean hasDaimyo; //se o (card/castelo) tem o especial
	
	
	public Card(Guild guild, BattleLine bl, int cardPoints) {
		super();
		this.guild = guild;
		this.bl = bl;
		this.cardPoints = cardPoints;
		this.hasDaimyo = true;
	}

	public Card(int cardPoints, boolean daimyo) {
		this.cardPoints = cardPoints;
		this.hasDaimyo = daimyo;

	}

	public int getCardPoints() {
		return this.cardPoints;
	}
	
	public Guild getGuild() {
		return guild;
	}

	public BattleLine getBattleLine() {
		return bl;
	}

	public boolean hasDaimyo() {
		return this.hasDaimyo;
	}
	

}
