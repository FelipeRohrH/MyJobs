package model;

import java.util.ArrayList;
import java.util.List;

import model.cards.Card;
import model.cards.Guild;
import model.player.Player;
import model.player.PlayerObserver;


public class BoardModel implements PlayerObserver{
	
	private List<Guild> guilds;
	private List<Card> cards; 
	private List<Dice> dices;
	private List<Player> players;
	
	public BoardModel() {
		guilds = new ArrayList<Guild>(6);
		cards = new ArrayList<Card>(14);
		dices = new ArrayList<Dice>(7);
		players = new ArrayList<Player>(2);
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
//		guilds.add();
//		guilds.add(new Guild("Yellow", 10));
//		guilds.add(new Guild("White", 8));
//		guilds.add(new Guild("Purple", 8));
//		guilds.add(new Guild("Red", 5));
//		guilds.add(new Guild("Black", 4));
//		guilds.add(new Guild("Green", 3));

	}
	
	public void addCards() {
//		//yellow
//		cards.add(new Card(1));
//		cards.add(new Card(1));
//		cards.add(new Card(2));
//		cards.add(new Card(3));
//		//white
//		cards.add(new Card(1));
//		cards.add(new Card(2));
//		cards.add(new Card(3));
//		//purple
//		cards.add(new Card(3));
//		cards.add(new Card(4));
//		//red
//		cards.add(new Card(2));
//		cards.add(new Card(2));
//		//black
//		cards.add(new Card(1));
//		cards.add(new Card(2));
//		//green
//		cards.add(new Card(3, false));
	}
	
	public void removeCard(int index) {
		
	}
	
	public Card getCard(int index) {
		return cards.get(index);
	}
	
	public List<Card> getCardList(){
		return this.cards;
	}
	/*---------------------------*/
	
	/*--------Player--------*/
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	
	/*----------------------*/
	
	
	
}
