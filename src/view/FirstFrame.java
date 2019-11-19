package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.GameController;

public class FirstFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GameController gc;
	private GameFrame gf;
	
	public FirstFrame() {
		setSize(400, 165);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
//		pack();
		
		gc = GameController.getInstance();

		initComponents();
	}

	private void initComponents() {

		getContentPane().setLayout(new BorderLayout());
//		getContentPane().setLayout(new FlowLayout());

		JPanel newPanel = new JPanel();
		JPanel newPanel2 = new JPanel();
		JPanel newPanel3 = new JPanel();
		JPanel newPanel4 = new JPanel();
		
//		newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
//		newPanel2.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
		JLabel lb = new JLabel("AGE OF WAR");
		lb.setFont(new Font("Courier New", Font.ITALIC, 30));
		lb.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel p1 = new JLabel("Player 1: ");
		JTextField tx1 = new JTextField(10);
		JLabel p2 = new JLabel("Player 2: ");
		JTextField tx2 = new JTextField(10);

		JButton btnStartGame = new JButton("Start!");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gf = new GameFrame();
				
				gc.addPlayers(tx1.getText(), tx2.getText());				
				
				gf.setVisible(true);
				
				setVisible(false);

				
			}
		});
		
		newPanel.add(lb);
		newPanel2.add(p1);
		newPanel2.add(tx1);
		newPanel2.add(p2);
		newPanel2.add(tx2);
		newPanel4.add(btnStartGame);

		getContentPane().add(newPanel, BorderLayout.PAGE_START);
		getContentPane().add(newPanel2);

		getContentPane().add(newPanel4, BorderLayout.PAGE_END);
	}

}
