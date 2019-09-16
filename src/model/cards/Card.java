package model.cards;

public class Card {
	
	private int cardPoints; //pontos de cada carta
	private boolean daimyo; //tem especial ou nao
	
	public Card() {
		
	}
	
	public Card(int cardPoints, boolean isDaimyo) {
		this.cardPoints = cardPoints;
		this.daimyo = isDaimyo;
	}

	
	public int getCardPoints() {
		return this.cardPoints;
	}

	
	public boolean getDaimyo() {
		return this.daimyo;
	}
	
	public String toString() {
		return  super.toString() + " " + cardPoints + " " + daimyo;
	}

}
