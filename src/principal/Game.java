package principal;
import java.awt.EventQueue;

import view.GameFrame;

public class Game {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				GameFrame tela = new GameFrame();
				tela.setVisible(true);
			}});

	}
}
