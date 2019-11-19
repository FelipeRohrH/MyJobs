package model.battleLines;

import model.battleLines.builder.BattleLineBuilder;

public class BattleLineDirector {

	private BattleLineBuilder builder;

	public BattleLineDirector(BattleLineBuilder builder) {
		this.builder = builder;
	}

	public void build(String[] troops, int value) {
		builder.reset();
		
		builder.buildTroops(troops);
		builder.buildLineValue(value);
	}

}
