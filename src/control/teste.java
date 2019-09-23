package control;

public class teste {

	public static void main(String[] args) {
		
		GameController gc = GameController.getInstance();
		
		gc.gameStart();
		gc.showDices();
		gc.rollDices();
		System.out.println();
		gc.showDices();
		gc.removeDice(0);
		gc.showDices();

	}

}
