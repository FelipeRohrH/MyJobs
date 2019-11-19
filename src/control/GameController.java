package control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import javax.swing.Icon;
import control.command.GameFluxInvoker;
import control.observer.Observer;
import model.BoardModel;
import model.Dice;
import model.Player;
import model.battleLines.BattleLineDirector;
import model.battleLines.builder.BattleLine;
import model.battleLines.builder.BattleLineBuilder;
import model.battleLines.builder.ConcreteBattleLineBuilder;
import model.cards.builder.Card;

public class GameController {

	private List<Observer> observers = new ArrayList<>();

	private BoardModel bm;
	private Random randomValue;
	private Stack<Card> selectedCardStack;
	private Card cardBoard[][];
	private BattleLine[] arrayBl;
	private boolean hasGameTurnStarted;

	private static GameController instance;

	private GameController() {
		bm = new BoardModel();
		randomValue = new Random();
		selectedCardStack = new Stack<Card>();

	}

	public synchronized static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
			return instance;
		} else {
			return instance;
		}
	}

	public void attach(Observer obs) {
		observers.add(obs);
	}

	public void detach(Observer obs) {
		observers.remove(obs);
	}

	/* ----------- DICES ----------- */
	public void addDices() {
		for (int i = 0; i < 7; i++) {
			Dice newDice = new Dice("dice");
			newDice.setIcon();
			bm.addDice(newDice);
		}

	}

	public void rollDices() {
		if (hasGameTurnStarted == false) {
			for (Dice dice : bm.getDiceList()) {
				dice.setType(randomValue.nextInt(6));

			}
			notifyRolledDices();
//			hasGameTurnStarted = true;
		} else {
			removeDice();

			if (bm.getDiceList().isEmpty()) {
				notifyTurnEnded();
			}
			for (Dice dice : bm.getDiceList()) {
				dice.setType(randomValue.nextInt(6));

			}
			notifyRolledDices();

		}
	}

	public void removeDice() {
		int lastDice = getDiceListSize() - 1;
		bm.removeDice(lastDice);

		notifyRemovedDice();

//		if(bm.getDiceList().isEmpty()) {
//			notifyNewTurnStarted();
//		}

	}

	public Dice getDice(int index) {
		return bm.getDice(index);
	}

	public int getDiceListSize() {
		return bm.getDiceList().size();
	}

	/* ----------------------------- */

	/* ----------- PLAYERS ----------- */
	public void addPlayers(String name1, String name2) { // "INIT GAME"
		Player p1 = new Player(name1);
		bm.addPlayer(p1);
		Player p2 = new Player(name2);
		bm.addPlayer(p2);

		notifyAddedPlayers(p1.getName(), p2.getName());
	}

	public void startNewTurn() {
		if(!selectedCardStack.empty()) {
			hasGameTurnStarted = true;
			notifyNewTurnStarted();
			
		}else {
			hasGameTurnStarted = false;
		}

	}

	/* -------------------------------- */

	/* ----------- CARDS ----------- */

	public Icon addCards(int row, int col) {
		cardBoard = bm.getCardBoard();

		if (cardBoard[row][col] == null) {
			return null;
		} else {
			return cardBoard[row][col].getIcon();
		}

	}

	public void selectedCard(int selectedRow, int selectedColumn) {
		addToCardStack(cardBoard[selectedRow][selectedColumn]);
		Card cardSelected = getCardStack().get(0);
		System.out.println(getCardStack());

		compareBLines(cardSelected);

		notifySelectedCard(cardSelected.getIcon(), cardSelected.getCardName());

	}

	public void deSelectCard() {
		removeFromCardStack();
		notifyDeselectedCard();
	}

	public Card getCard(int index) {
		return bm.getCard(index);
	}

	public int getCardListSize() {
		return bm.getCardList().size();
	}

	public Stack<Card> getCardStack() {
		return selectedCardStack;
	}

	public void addToCardStack(Card c) {
		selectedCardStack.push(c);
	}

	public void removeFromCardStack() {
		selectedCardStack.pop();

	}
	/* ----------------------------- */

	/* -------------- BL --------------------- */
	
	/*
	 * Logica é simples... utilizo variaveis e listas auxiliares para guardar os dados e comparar valores para saber 
	 * se no final tenho os dados certos. Em paralelo eu verifico oque pode ser completado e atualizo a view dizendo 
	 * para habilitar o botão e salvo os dados que seriam utilizados em uma lista de listas de dados(Dice), a mesma é 
	 * retornada posteriormente em outro metodo que pega a lina em especifico e remove os dados.
	 */
	public List<List<Dice>> compareBLines(Card c) {
		List<List<Dice>> listOfDicesToRemove = new ArrayList<List<Dice>>();
		
		List<String> arrayBlTypes = getBlTypes(c);
		List<Integer> arrayBlValues = getBlvalue(c);

		List<Dice> dicesToRemove = new ArrayList<Dice>();

		int loopCount = 0;

		for (String typeLine : arrayBlTypes) {

			int valueLine = arrayBlValues.get(loopCount);
			int sumDiceValues = 0;
			List<Dice> temporaryDices = new ArrayList<Dice>();

			for (Dice d : bm.getDiceList()) {
				if (d.getType().equals(typeLine) || d.getType().contains(typeLine)) {
					if (d.getType().contains("Infantry")) {
						sumDiceValues += d.getValue();
						if (sumDiceValues >= valueLine) {
							for (Dice dice : temporaryDices) {
								dicesToRemove.add(dice);
							}
							dicesToRemove.add(d);
							sumDiceValues = 0;
							notifyBlineEnable(loopCount);
							listOfDicesToRemove.add(loopCount, dicesToRemove);
							dicesToRemove.clear();
							break;
						} else {
							temporaryDices.add(d);
						}

					} else if (d.getType().equals("Cavalry")) {
						sumDiceValues += d.getValue();
						if (sumDiceValues >= valueLine) {

							for (Dice dice : temporaryDices) {
								dicesToRemove.add(dice);
							}
							dicesToRemove.add(d);
							sumDiceValues = 0;
							notifyBlineEnable(loopCount);
							listOfDicesToRemove.add(loopCount, dicesToRemove);
							dicesToRemove.clear();
							break;
						} else {
							temporaryDices.add(d);
						}

					} else if (d.getType().equals("Archery")) {
						sumDiceValues += d.getValue();
						if (sumDiceValues >= valueLine) {
							for (Dice dice : temporaryDices) {
								dicesToRemove.add(dice);
							}
							dicesToRemove.add(d);
							sumDiceValues = 0;
							notifyBlineEnable(loopCount);
							listOfDicesToRemove.add(loopCount, dicesToRemove);
							dicesToRemove.clear();
							break;
						} else {
							temporaryDices.add(d);
						}

					} else if (d.getType().equals("Daimyo")) {
						sumDiceValues += d.getValue();
						if (sumDiceValues >= valueLine) {
							for (Dice dice : temporaryDices) {
								dicesToRemove.add(dice);
							}
							dicesToRemove.add(d);
							sumDiceValues = 0;
							notifyBlineEnable(loopCount);
							listOfDicesToRemove.add(loopCount, dicesToRemove);
							dicesToRemove.clear();
							break;
						} else {
							temporaryDices.add(d);
						}
					}

				}

			}

			temporaryDices.clear();
			loopCount++;

		}

		return listOfDicesToRemove;

	}

	public void completeBlines(Card c, int linePosition) {
		
		List<Dice> diceToRemove = compareBLines(c).get(linePosition); 
		
		for (Dice d : bm.getDiceList()) {
			for (Dice dice : diceToRemove) {
				if(d.equals(dice)) {
					bm.getDiceList().remove(d);
					notifyRemovedDice();
				}
			}
		}
		
		

	}

	public List<String> getBlTypes(Card c) {
		List<String> lineTypes = new ArrayList<String>();
		arrayBl = c.getBl();
		String[] arrayTroops = {};

		for (BattleLine bl : arrayBl) {
			int linesCount = 0;
			arrayTroops = bl.getTroops();
			lineTypes.add(arrayTroops[linesCount]);
			linesCount++;

		}
//		for (String string : lineTypes) {
//			System.out.println(string);
//		}
		return lineTypes;
	}

	public List<String> getDiceTypes() {
		List<String> diceTypes = new ArrayList<String>();

		for (Dice d : bm.getDiceList()) {
			diceTypes.add(d.getType());
		}

		for (String string : diceTypes) {
			System.out.println(string);
		}
		return diceTypes;

	}

	public List<Integer> getBlvalue(Card c) {
		List<Integer> lineValues = new ArrayList<Integer>();
		arrayBl = c.getBl();
		int[] arrayTroops = new int[4];

		for (BattleLine bl : arrayBl) {
			int linesCount = 0;
			arrayTroops[linesCount] = bl.getLineValue();
			lineValues.add(arrayTroops[linesCount]);
			linesCount++;

		}
//		for (String string : lineTypes) {
//			System.out.println(string);
//		}
		return lineValues;

//		Card c = cardBoard[row][col];
//		arrayBl = c.getBl();
//		int lineValue = 0;
//
//		for (BattleLine bl : arrayBl) {
//			lineValue = bl.getLineValue();
//			
//		}
//		return lineValue;
	}

	public void getDiceValue() {

	}
	/* -------------- BL --------------------- */

	////////////////// Listers ////////////////////

	public void notifyRolledDices() {
		for (Observer cO : observers) {
			cO.updateDiceTable();
		}
	}

	public void notifyRemovedDice() {
		for (Observer cO : observers) {
			cO.updateDiceTable();
		}
	}

	public void notifySelectedCard(Icon i, String name) {
		for (Observer cO : observers) {
			cO.selectedCard(i, name);
		}
	}

	public void notifyDeselectedCard() {
		for (Observer cO : observers) {
			cO.deSelectedCard();
		}
	}

	public void notifyAddedPlayers(String n1, String n2) {
		for (Observer cO : observers) {
			cO.addedPlayers(n1, n2);

		}
	}

	public void notifyNewTurnStarted() {
		for (Observer cO : observers) {
			cO.gameTurnStarted();
		}
	}

	public void notifyTurnEnded() {
		for (Observer cO : observers) {
			cO.gameTurnEnded();
		}
	}

	public void notifyBlineEnable(int line) {
		for (Observer cO : observers) {
			cO.enableBline(line);
		}

	}

}
