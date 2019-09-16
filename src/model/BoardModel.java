package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.cards.Card;


public class BoardModel {
	
	private static BoardModel instance;
	
	private Player player1;
	private Player player2;
	
	private List<Card> cardsList;
	private List<Dice> dices;
	
	
	private BoardModel() {
		dices = new ArrayList<Dice>(6);
		
	}
	
	public synchronized static BoardModel getInstance(){
		if(instance == null) {
			instance = new BoardModel();
			return instance;
		}else {
			return instance;
		}
	}
	
	public void addCards() {

	}
	
	public void removeCard(int index) {
		cardsList.remove(index);
	}
	
	public void addDices() {
		for (int i = 0; i < dices.size(); i++) {
			dices.set(i, new Dice());
		}
	}
	
	public void removeDice(int index) {
		dices.remove(index);
	}
	
	public void initGameCards() {
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
		cardsList.add(new Card());
	}
	
	
}
