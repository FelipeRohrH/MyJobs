package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.cards.builder.Card;

public class Player {
	
	private String name;
	private int points;

	private Map<Guild, List<Card>> myCards; 
	
	public Player(String name) {
		super();
		this.name = name;
		this.myCards = new HashMap<Guild, List<Card>>();
	}
	
	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public Map<Guild, List<Card>> getMyCards() {
		return this.myCards;
	}
	

		
}
