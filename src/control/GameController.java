package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.BoardModel;
import model.Dice;

public class GameController {
	
	private List<ControllerObserver> observers = new ArrayList<>();
	private BoardModel bm;
	private Random randomValue;

	private static GameController instance;
	
	private GameController() {
		bm = new BoardModel();
		randomValue = new Random();
	}
	
	public synchronized static GameController getInstance(){
		if(instance == null) {
			instance = new GameController();
			return instance;
		}else {
			return instance; 
		}
	}
	
	public void attach(ControllerObserver obs) {
		observers.add(obs);
	}
	public void detach(ControllerObserver obs) {
		observers.remove(obs);
	}
	
	public void gameStart() {
		addDices();
	}
	
	/* ----------- DICES -----------*/	
	public void rollDices() {
		for (Dice dice : bm.getDiceList()) {
			dice.rollDiceValue(randomValue.nextInt(6));
			notifyRolledDices(dice.getValue());
		}
			
	}
	
	public void addDices() {
		for (int i = 0; i < 7; i++) {
			Dice newDice = createNewDice();
			bm.addDices(newDice);
		}
		notifyAddedDices(bm.getDiceList());
	}
	
	public void removeDice(int index) {
		bm.removeDice(index);
		notifyRemovedDice(index);
	}
	
	public Dice createNewDice() {
		Dice d = new Dice();
		return d;
	}
	/* -----------------------------*/
	
	
	/* ----------- CARDS -----------*/	
	public void addCards() {
		
	}
	
	public void removeCard() {
		
	}
	
	
	
	public void createCards() {
		
	}
	/* -----------------------------*/
	
	
	
	public void notifyRolledDices(String value) {
		for (ControllerObserver cO : observers) {
			cO.rollDices(value);
		}
	}
	
	public void notifyAddedDices(List<Dice> dices) {
		for (ControllerObserver cO : observers) {
			cO.addDices(dices);
		}
	}
	
	public void notifyRemovedDice(int index) {
		for (ControllerObserver cO : observers) {
			cO.removeDice(index);
		}
	}

	
	//teste:
	public void showDices() {
		int i = 1;
		for (Dice d : bm.getDiceList()) {
			System.out.println(i++ + " " + d.getValue());
		}
		
	}
	
	
}

