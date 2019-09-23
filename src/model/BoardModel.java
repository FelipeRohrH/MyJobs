package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.cards.Card;
import model.cards.Guild;


public class BoardModel {
	
	private Player player2;
	private Player player1;
	
	private List<Guild> guildList;
	private List<Dice> dices;
	
	public BoardModel() {
		dices = new ArrayList<Dice>(6);
	}
	
	
	/*--------Dices--------*/
	public void addDices(Dice dice) {
		dices.add(dice);
	}
	
	public void removeDice(int index) {
		dices.remove(index);
	}
	
	public Dice getDice(int index) {
		return dices.get(index);
	}
	
	public List<Dice> getDiceList() {
		return this.dices;
	}
	/*---------------------*/
	
	
	
	/*--------Guids&Cards--------*/
	private void addGuilds() {
		guildList.add(new Guild("Yellow", 10));
		guildList.add(new Guild("White", 8));
		guildList.add(new Guild("Purple", 8));
		guildList.add(new Guild("Red", 5));
		guildList.add(new Guild("Black", 4));
		guildList.add(new Guild("Green", 3));
		
	}
	
	public void removeCard(int index) {
		
	}
	/*---------------------------*/
	
	/*--------Player--------*/
	
	/*----------------------*/
	
	
	
}
