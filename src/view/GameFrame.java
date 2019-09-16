package view;

import javax.swing.JFrame;


public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainPanel mp;

	public GameFrame() {
//		setSize(1200, 600);
//		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);

		this.mp = new MainPanel();

		add(mp);

	}


}


