package model;

import java.util.ArrayList;
import java.util.List;

import model.cards.Guild;
import model.player.Player;
import model.player.PlayerObserver;


public class BoardModel implements PlayerObserver{
	
	private List<Guild> guilds;
	private List<Dice> dices;
	private List<Player> player;
	
	public BoardModel() {
		guilds = new ArrayList<Guild>(6);
		dices = new ArrayList<Dice>(7);
		player = new ArrayList<Player>(2);
	}
	
	/*--------Dices--------*/
	public void addDice(Dice dice) {
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
	public void addGuild(Guild g) {
		guilds.add(g);
//		guilds.add(new Guild("Yellow", 10));
//		guilds.add(new Guild("White", 8));
//		guilds.add(new Guild("Purple", 8));
//		guilds.add(new Guild("Red", 5));
//		guilds.add(new Guild("Black", 4));
//		guilds.add(new Guild("Green", 3));

	}
	
	public void addCard() {
		
	}
	
	public void removeCard(int index) {
		
	}
	/*---------------------------*/
	
	/*--------Player--------*/
	
	
	
	/*----------------------*/
	
	
	
}
