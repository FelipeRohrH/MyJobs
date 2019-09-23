package control;

import java.util.List;

public interface ControllerObserver {
	
	void rollDices(String diceValue);
	void addDices(List<?> dices);
	void removeDice(int index);
}
