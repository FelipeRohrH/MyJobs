package model.cards.builder;

import javax.swing.Icon;

import model.Guild;
import model.battleLines.builder.BattleLine;

public abstract class CardBuilder {
	
	public abstract Card getCard();
	public abstract void reset(); 
	
	public void buildName(String name) {
		
	}
	public void buildPoints(int points) {
		
	}
	public void buildGuid(Guild g) {
		
	}
	public void buildBLines(BattleLine[] bl) {
		
	}
	public void buildIcon() {
		
	}
	public void buildDaimyo(boolean daimyo) {
		
	}
}
