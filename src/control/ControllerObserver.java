package control;

import java.util.List;

public interface ControllerObserver {
	
	void rolledDices(String diceValue);
	void addedDices(List<?> dices);
	void removedDice(int index);
	void addedPlayers(String p1, String p2);
}
