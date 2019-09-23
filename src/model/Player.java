package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.cards.Card;
import model.cards.Guild;

public class Player {
	
	private String name;
	private int points;

	private Map<Guild, List<Card>> myCards = new HashMap<Guild, List<Card>>();

	public Player() {
		
	}
	
	public Player(String name) {
		super();
		this.name = name;
		
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
		
}
