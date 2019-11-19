package control.observer;

import javax.swing.Icon;

public interface Observer {
	
	void updateDiceTable();
	void selectedCard(Icon i, String name);
	void deSelectedCard();
	void addedPlayers(String p1, String p2);
	void gameTurnStarted();
	void gameTurnEnded();
	
	void enableBline(int line);
}
