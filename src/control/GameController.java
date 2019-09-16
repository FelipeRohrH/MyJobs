package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.BoardModel;

public class GameController implements Controller{
	
	private List<Observer> observers = new ArrayList<>();
	private BoardModel bm;
	
	public GameController() {
		bm = BoardModel.getInstance();
	}
	
	
	public void attach(Observer obs) {
		observers.add(obs);
	}

	public void detach(Observer obs) {
		observers.remove(obs);
	}

	@Override
	public void rollDices() {
		bm.addDices();
		
		for (Observer obs : observers) {
			obs.notifyRolledDices();
		}
	}


	@Override
	public void removeDice(int index) {
		
	}

	@Override
	public void selectBattleLine() {
		// TODO Auto-generated method stub
		
	}
}
