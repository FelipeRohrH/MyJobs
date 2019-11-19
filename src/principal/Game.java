package principal;
import java.awt.EventQueue;
import java.io.IOException;

import view.FirstFrame;
import view.GameFrame;

public class Game {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				FirstFrame f;
				f = new FirstFrame();
				f.setVisible(true);

			}});

	}
}
