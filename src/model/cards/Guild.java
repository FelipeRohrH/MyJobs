package model.cards;

import java.util.ArrayList;
import java.util.List;

public class Guild {
	
	private String guildColor;
	private int guildPoints;

//	private List<Card> cardsModel; 
	
	public Guild(String color, int guildPoints) {
		super();
		this.guildColor = color;
		this.guildPoints = guildPoints;
//		cardsModel = new ArrayList<Card>(14);
//		initCards();
	}

	public String getGuildColor() {
		return guildColor;
	}

	public int getGuildPoints() {
		return guildPoints;
	}
	
//	public void initCards() {
//		//yellow
//		cardsModel.add(new Card(1));
//		cardsModel.add(new Card(1));
//		cardsModel.add(new Card(2));
//		cardsModel.add(new Card(3));
//		//white
//		cardsModel.add(new Card(1));
//		cardsModel.add(new Card(2));
//		cardsModel.add(new Card(3));
//		//purple
//		cardsModel.add(new Card(3));
//		cardsModel.add(new Card(4));
//		//red
//		cardsModel.add(new Card(2));
//		cardsModel.add(new Card(2));
//		//black
//		cardsModel.add(new Card(1));
//		cardsModel.add(new Card(2));
//		//green
//		cardsModel.add(new Card(3, false));
//	}
	
}
