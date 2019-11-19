package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.battleLines.BattleLineDirector;
import model.battleLines.builder.BattleLine;
import model.battleLines.builder.BattleLineBuilder;
import model.battleLines.builder.ConcreteBattleLineBuilder;
import model.cards.CardDirector;
import model.cards.builder.Card;
import model.cards.builder.CardBuilder;
import model.cards.builder.ConcreteCardBuilder;

public class BoardModel {
	
	private List<Guild> guilds;
	private List<Card> cards; 
	private List<Dice> dices;
	private List<Player> players;
	
	private Card cardBoard[][];
	
	
	public BoardModel() {
		guilds = new ArrayList<Guild>(6);
		cards = new ArrayList<Card>(14);
		dices = new ArrayList<Dice>(7);
		players = new ArrayList<Player>(2);
		
	
		createCards();
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
	public void createGuilds() {
		guilds.add(new Guild("Yellow", 10));
//		guilds.add(new Guild("White", 8));
//		guilds.add(new Guild("Purple", 8));
//		guilds.add(new Guild("Red", 5));
//		guilds.add(new Guild("Black", 4));
//		guilds.add(new Guild("Green", 3));

	}

	public void createCards() {
		
		Guild yellowGuild = new Guild("yellow", 10);
		Guild redGuild = new Guild("red", 5);
		Guild whiteGuild = new Guild("white", 8);
		Guild purpleGuild = new Guild("purple", 8);
		Guild blackGuild = new Guild("black", 4);		
		Guild greenGuild = new Guild("green", 3);

		//ODANI depois desse eu desisti de implementar builder em BattleLines...
		BattleLineBuilder blOdani1 = new ConcreteBattleLineBuilder();
		BattleLineDirector bl1 = new BattleLineDirector(blOdani1);
		bl1.build(new String[]{"Infantry"}, 10);

		CardBuilder odaniCard = new ConcreteCardBuilder(); 
		CardDirector odaniDirector = new CardDirector(odaniCard);
		odaniDirector.build("Odani", 1, yellowGuild, new BattleLine[]{blOdani1.getBattleLine()}, true);
		
		//GIFU
		BattleLine gifu1 = new BattleLine(new String[]{"Daimyo"}, 1);
		BattleLine gifu2 = new BattleLine(new String[]{"Archery"}, 1);
		BattleLine gifu3 = new BattleLine(new String[]{"Cavalry"}, 1);
		
		CardBuilder gifuCard = new ConcreteCardBuilder();
		CardDirector gifuDirector = new CardDirector(gifuCard);
		gifuDirector.build("Gifu", 1, yellowGuild, new BattleLine[]{gifu1, gifu2, gifu3}, true);
			
		//AZUCHI
		BattleLine azuchi1 = new BattleLine(new String[]{"Archery"}, 1);
		BattleLine azuchi2 = new BattleLine(new String[]{"Cavalry", "Cavalry"}, 2);
		BattleLine azuchi3 = new BattleLine(new String[]{"Infantry"}, 5);
		
		CardBuilder azuchiCard = new ConcreteCardBuilder();
		CardDirector azuchiDirector = new CardDirector(azuchiCard);
		azuchiDirector.build("Azuchi", 1, yellowGuild, new BattleLine[]{azuchi1, azuchi2, azuchi3}, true);
		
		//MATSUMOTO
		BattleLine matsumoto1 = new BattleLine(new String[]{"Archery"}, 1);
		BattleLine matsumoto2 = new BattleLine(new String[]{"Archery"},  1);
		BattleLine matsumoto3 = new BattleLine(new String[]{"Infantry"}, 7);
		
		CardBuilder  matsumotoCard = new ConcreteCardBuilder();
		CardDirector matsumotoDirector = new CardDirector(matsumotoCard);
		matsumotoDirector.build("Matsumoto", 1, yellowGuild, new BattleLine[]{matsumoto1, matsumoto2, matsumoto3}, true);
		
//		//GASSANTODA
		BattleLine gassantoda1 = new BattleLine(new String[]{"Daimyo"}, 1);
		BattleLine gassantoda2 = new BattleLine(new String[]{"Infantry"}, 8);
		
		CardBuilder  gassantodaCard = new ConcreteCardBuilder();
		CardDirector gassantodaDirector = new CardDirector(gassantodaCard);
		gassantodaDirector.build("Gassantoda", 2, redGuild, new BattleLine[]{gassantoda1, gassantoda2}, true);
		
		//TAKAHASHI
		BattleLine takahashi1 = new BattleLine(new String[]{"Cavalry", "Cavalry"}, 2);
		BattleLine takahashi2 = new BattleLine(new String[]{"Daimyo"}, 1);
		BattleLine takahashi3 = new BattleLine(new String[]{"Infantry"}, 2);
		
		CardBuilder  takahashiCard = new ConcreteCardBuilder();
		CardDirector takahashiDirector = new CardDirector(takahashiCard);
		takahashiDirector.build("Takahashi", 2, redGuild, new BattleLine[]{takahashi1, takahashi2, takahashi3}, true);
		
		//EDO
		BattleLine edo1 = new BattleLine(new String[]{"Archery", "Cavalry"}, 2);
		BattleLine edo2 = new BattleLine(new String[]{"Archery", "Cavalry"}, 2);
		BattleLine edo3 = new BattleLine(new String[]{"Infantry"}, 3);
		
		CardBuilder  edoCard = new ConcreteCardBuilder();
		CardDirector edoDirector = new CardDirector(edoCard);
		edoDirector.build("Edo", 3, whiteGuild, new BattleLine[]{edo1, edo2, edo3}, true);
		
//		//Kiyosu
		BattleLine kiyosu1 = new BattleLine(new String[]{"Daimyo"}, 1);
		BattleLine kiyosu2 = new BattleLine(new String[]{"Archery"}, 1);
		BattleLine kiyosu3 = new BattleLine(new String[]{"Cavalry"}, 1);
		BattleLine kiyosu4 = new BattleLine(new String[]{"Infantry"}, 3);
		
		CardBuilder kiyosuCard = new ConcreteCardBuilder();
		CardDirector kiyosuDirector = new CardDirector(kiyosuCard);
		kiyosuDirector.build("Kiyosu", 2, whiteGuild, new BattleLine[]{kiyosu1, kiyosu2, kiyosu3, kiyosu4}, true);
		
//		//Inuyama
		BattleLine inuyama1 = new BattleLine(new String[]{"Daimyo"}, 1);
		BattleLine inuyama2 = new BattleLine(new String[]{"Archery", "Archery"}, 2);
		
		CardBuilder  inuyamaCard = new ConcreteCardBuilder();
		CardDirector inuyamaDirector = new CardDirector(inuyamaCard);
		inuyamaDirector.build("Inuyama", 1, whiteGuild, new BattleLine[]{inuyama1, inuyama2}, true);
		
		//Matsuyama
		BattleLine matsuyama1 = new BattleLine(new String[]{"Daimyo"}, 1);
		BattleLine matsuyama2 = new BattleLine(new String[]{"Infantry"}, 4);
		BattleLine matsuyama3 = new BattleLine(new String[]{"Infantry"}, 4);
		
		CardBuilder  matsuyamaCard = new ConcreteCardBuilder();
		CardDirector matsuyamaDirector = new CardDirector(matsuyamaCard);
		matsuyamaDirector.build("Matsuyama", 2, blackGuild, new BattleLine[]{matsuyama1, matsuyama2, matsuyama3}, true);
		
		//Marugame
		BattleLine marugame1 = new BattleLine(new String[]{"Daimyo", "Daimyo"}, 2);
		BattleLine marugame2 = new BattleLine(new String[]{"Cavalry"}, 1);
		
		CardBuilder  marugameCard = new ConcreteCardBuilder();
		CardDirector marugameDirector = new CardDirector(marugameCard);
		marugameDirector.build("Marugame", 1, blackGuild, new BattleLine[]{marugame1, marugame2}, true);
		
		//Kasugayama
		BattleLine kasugayama1 = new BattleLine(new String[]{"Archery", "Archery"}, 2);
		BattleLine kasugayama2 = new BattleLine(new String[]{"Cavalry", "Cavalry"}, 2);
		
		CardBuilder  kasugayamaCard = new ConcreteCardBuilder();
		CardDirector kasugayamaDirector = new CardDirector(kasugayamaCard);
		kasugayamaDirector.build("Kasugayama", 4, purpleGuild, new BattleLine[]{kasugayama1, kasugayama2}, true);

		//Kitanosho
		BattleLine kitanosho1 = new BattleLine(new String[]{"Daimyo"},  1);
		BattleLine kitanosho2 = new BattleLine(new String[]{"Archery", "Cavalry"}, 2);
		BattleLine kitanosho3 = new BattleLine(new String[]{"Infantry"}, 6);
		
		CardBuilder  kitanoshoCard = new ConcreteCardBuilder();
		CardDirector kitanoshoDirector = new CardDirector(kitanoshoCard);
		kitanoshoDirector.build("Kitanosho", 3, purpleGuild, new BattleLine[]{kitanosho1, kitanosho2, kitanosho3}, true);
		
		//Kumamoto
		BattleLine kumamoto1 = new BattleLine(new String[]{"Daimyo", "Daimyo"}, 2);
		BattleLine kumamoto2 = new BattleLine(new String[]{"Archery"},  1);
		BattleLine kumamoto3 = new BattleLine(new String[]{"Cavalry"}, 1);
		BattleLine kumamoto4 = new BattleLine(new String[]{"Infantry"}, 4);
		
		CardBuilder  kumamotoCard = new ConcreteCardBuilder();
		CardDirector kumamotoDirector = new CardDirector(kumamotoCard);

		kumamotoDirector.build("Kumamoto", 3, greenGuild, new BattleLine[]{kumamoto1, kumamoto2, kumamoto3, kumamoto4}, false);
	
		cardBoard = new Card[4][4];
		cardBoard[0][0] = odaniCard.getCard();
		cardBoard[0][1] = gifuCard.getCard();
		cardBoard[0][2] = azuchiCard.getCard();
		cardBoard[0][3] = matsumotoCard.getCard();
//		
		cardBoard[1][0] = gassantodaCard.getCard();
		cardBoard[1][1] = inuyamaCard.getCard();
		cardBoard[1][2] = edoCard.getCard();
		cardBoard[1][3] = kiyosuCard.getCard();
//		
		cardBoard[2][0] = takahashiCard.getCard();
		cardBoard[2][1] = matsuyamaCard.getCard();
		cardBoard[2][2] = marugameCard.getCard();	
		cardBoard[2][3] = kumamotoCard.getCard();
//		
		cardBoard[3][0] = kitanoshoCard.getCard();
		cardBoard[3][1] = kasugayamaCard.getCard();
		cardBoard[3][2] = null;
		cardBoard[3][3] = null;

	}
	
	
	public Card[][] getCardBoard(){
		return this.cardBoard;
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
