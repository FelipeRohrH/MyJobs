package model.cards;

public class Card{
	
	private int cardPoints; //pontos de cada carta
	private boolean hasDaimyo; //tem especial ou nao
	
	public Card(int cardPoints) {
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

	public boolean hasDaimyo() {
		return this.hasDaimyo;
	}
	

}
