package model.cards.builder;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Guild;
import model.battleLines.builder.BattleLine;

public class Card {
	
	private String cardName;
	private int cardPoints;
	private Guild guild;
	private BattleLine[] bl;
	private Icon icon;
	private boolean hasDaimyo;
	
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public void setCardPoints(int cardPoints) {
		this.cardPoints = cardPoints;
	}
	public void setGuild(Guild guild) {
		this.guild = guild;
	}
	public void setBl(BattleLine[] bl) {
		this.bl = bl;
	}
	public void setIcon() {
		this.icon = new ImageIcon("images/cards/" + getCardName() + ".png");;
	}
	public void setHasDaimyo(boolean hasDaimyo) {
		this.hasDaimyo = hasDaimyo;
	}
	
	public String getCardName() {
		return cardName;
	}
	public int getCardPoints() {
		return cardPoints;
	}
	public Guild getGuild() {
		return guild;
	}
	public BattleLine[] getBl() {
		return bl;
	}
	public Icon getIcon() {
		return icon;
	}
	public boolean isHasDaimyo() {
		return hasDaimyo;
	}

}
