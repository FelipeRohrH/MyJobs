package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import control.GameController;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image img;
	private GameController gc;

	public MainPanel() {
		
		gc = new GameController();
		
		ImageIcon ii = new ImageIcon("F:/Workspace/aow-ppr/imagens/fundo2.png");
		img = ii.getImage();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);

	}

}
