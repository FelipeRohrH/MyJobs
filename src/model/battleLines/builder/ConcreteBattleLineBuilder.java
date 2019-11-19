package model.battleLines.builder;

public class ConcreteBattleLineBuilder extends BattleLineBuilder{

	private BattleLine bl;
	
	@Override
	public BattleLine getBattleLine() {
		return this.bl;
	}

	@Override
	public void reset() {
		this.bl = new BattleLine(null, 0);
		
	}

	@Override
	public void buildTroops(String[] troops) {
		this.bl.setTroops(troops);
	}
	
	@Override
	public void buildLineValue(int value) {
		this.bl.setLineValue(value);
	}
	
	
}
