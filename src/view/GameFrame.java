package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import control.GameController;
import control.observer.Observer;
import sun.awt.image.PixelConverter.Bgrx;


public class GameFrame extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	class DiceModel extends AbstractTableModel{

		private static final long serialVersionUID = 1L;

		@Override
		public int getColumnCount() {
			return gc.getDiceListSize();
		}

		@Override
		public int getRowCount() {
			return 1;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return gc.getDice(columnIndex).getIcon();
		
		}
		

	}	
	
	class DiceRenderer extends DefaultTableCellRenderer {
		
		private static final long serialVersionUID = 1L;
		
		@Override
		public Component getTableCellRendererComponent(JTable table, 
													   Object value, 
													   boolean isSelected, 
													   boolean hasFocus,
													   int row, 
													   int column) {
			setIcon((ImageIcon) value);
			
			return this;
		}
		
	}
	
	class CardModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public int getRowCount() {
			return 4;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return gc.addCards(rowIndex, columnIndex);
			
		}
		
	}
	
	class CardRenderer extends DefaultTableCellRenderer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@Override
		public Component getTableCellRendererComponent(JTable table, 
													   Object value, 
													   boolean isSelected, 
													   boolean hasFocus,
													   int row, 
													   int column) {
			
			setIcon((ImageIcon) value);
			
			return this;
		}
	}
	
	private GameController gc;

	private DiceModel diceModel;
	private CardModel cardModel;
	
	private JPanel dicePanel;
	private JTable diceTable;
	private JButton btnRollDice;
	private JButton btnRemoveDice;
	
	private JPanel playerTwo;
	private JPanel playerOne;
	private JLabel p1;
	private JLabel p2;
	private JLabel lbP1Name;
	private JLabel lbP2Name;
	private JLabel lbP1Points;
	private JLabel lbP2Points;
	private JButton btnStart1;
	private JButton btnStart2;
	
	private JPanel cardPanel;
	private JTable cardTable;
	private JButton btnLine1;
	private JButton btnLine2;
	private JButton btnLine3;
	private JButton btnLine4;

	private JLabel bigCard;
	private BufferedImage myPicture;


	public GameFrame() {
		
		gc = GameController.getInstance();
		gc.attach(this);
		
		setSize(1162, 726);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
//		setUndecorated(true);
		
		diceModel = new DiceModel();
		cardModel = new CardModel();
		
		initComponents();
		pack();
	}
	
	private void initComponents() {
		
		getContentPane().setLayout(new BorderLayout());
		
		dicePanel = new JPanel();
		dicePanel.setLayout(new BoxLayout(dicePanel, BoxLayout.Y_AXIS));
		
		initDices();
		JPanel tablePanel = new JPanel();
		tablePanel.add(diceTable);
		
		JPanel buttonsPanel = new JPanel();
		
		btnRollDice = new JButton("Roll");
		btnRollDice.setEnabled(false);
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(gc.getDiceListSize() > 0) {
					disableBlines();
					
					gc.rollDices();
					if(!gc.getCardStack().empty()) {
						gc.compareBLines(gc.getCardStack().get(0));
						
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Your round ended!");
					btnRollDice.setEnabled(false);
				}
				
			}
		});

		buttonsPanel.add(btnRollDice);
		
		
		cardPanel = new JPanel();
		cardPanel.setLayout(new BorderLayout());
		initCards();
		
		JPanel bLines = new JPanel();
		bLines.setLayout(new BoxLayout(bLines, BoxLayout.Y_AXIS));
		initBattleLines();
		
//		bLines.add(Box.createRigidArea(new Dimension(40,0)));
		bLines.add(Box.createRigidArea(new Dimension(0,140)));
		bLines.add(btnLine1);
		bLines.add(Box.createRigidArea(new Dimension(0,40)));
		bLines.add(btnLine2);
		bLines.add(Box.createRigidArea(new Dimension(0,40)));
		bLines.add(btnLine3);
		bLines.add(Box.createRigidArea(new Dimension(0,40)));
		bLines.add(btnLine4);
//		bLines.add(Box.createRigidArea(new Dimension(40,40)));
		
		dicePanel.add(buttonsPanel);
		dicePanel.add(tablePanel);
		getContentPane().add(dicePanel, BorderLayout.PAGE_START);
	
		
		cardPanel.add(cardTable, BorderLayout.LINE_START);
		cardPanel.add(bigCard,  BorderLayout.CENTER);
		cardPanel.add(bLines, BorderLayout.LINE_END);
		getContentPane().add(cardPanel, BorderLayout.LINE_START);
		
		
		JPanel players = new JPanel(new BorderLayout());
		initPlayers();
		
		players.add(playerOne, BorderLayout.LINE_START);
		players.add(playerTwo, BorderLayout.LINE_END);
		getContentPane().add(players, BorderLayout.PAGE_END);
	
	}
	
	private void initBattleLines() {
		btnLine1 = new JButton(" <- Line 1");
		btnLine1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gc.completeBlines(gc.getCardStack().get(0), 0);
				gc.rollDices();
			}
		});
		
		btnLine2= new JButton(" <- Line 2");
		btnLine2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gc.completeBlines(gc.getCardStack().get(0), 1);
				gc.rollDices();
			}
		});
		
		btnLine3 = new JButton(" <- Line 3");
		btnLine3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gc.completeBlines(gc.getCardStack().get(0), 2);
				gc.rollDices();
			}
		});
		
		btnLine4 = new JButton(" <- Line 4");
		btnLine4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gc.completeBlines(gc.getCardStack().get(0), 3);
				gc.rollDices();
			}
		});
		
		btnLine1.setEnabled(false);
		btnLine2.setEnabled(false);
		btnLine3.setEnabled(false);
		btnLine4.setEnabled(false);
		
	}

	private void initDices() {
		gc.addDices();
		
		diceTable = new JTable();
		diceTable.setModel(this.diceModel);
//		for (int x=0;x<diceTable.getColumnModel().getColumnCount();x++) {
//			diceTable.getColumnModel().getColumn(x).setWidth(115);
//			diceTable.getColumnModel().getColumn(x).setMinWidth(115);
//			diceTable.getColumnModel().getColumn(x).setMaxWidth(200);
//		}

//		diceTable.setPreferredSize(new Dimension(600, 100));
		diceTable.setShowGrid(false);
		diceTable.setRowHeight(100);
		diceTable.setOpaque(false);
		diceTable.setDefaultRenderer(Object.class, new DiceRenderer());
		((DefaultTableCellRenderer)diceTable.getDefaultRenderer(Object.class)).setOpaque(false);
		
		diceTable.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//        		gc.selectedDice(diceTable.getSelectedColumn());
//        			
//        		
//        	}
		});
	}

	private void initCards() {
		cardTable = new JTable();
		cardTable.setModel(this.cardModel);
		for (int x = 0 ; x < cardTable.getColumnModel().getColumnCount(); x++) {
			cardTable.getColumnModel().getColumn(x).setWidth(130);
			cardTable.getColumnModel().getColumn(x).setMinWidth(150);
			cardTable.getColumnModel().getColumn(x).setMaxWidth(150);
		}
		cardTable.setRowHeight(130);
		cardTable.setShowGrid(false);
		cardTable.setIntercellSpacing(new Dimension(10, 0));
		cardTable.setDefaultRenderer(Object.class, new CardRenderer());
		
		cardTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
        			if(gc.getCardStack().empty()) {
        				gc.selectedCard(cardTable.getSelectedRow(), cardTable.getSelectedColumn());
        			}else {
        				gc.removeFromCardStack();        				
        				gc.selectedCard(cardTable.getSelectedRow(), cardTable.getSelectedColumn());
        				
        			}
        			
        		
        	}
		});
 	
		///BigCard
		bigCard = new JLabel();
		try {
			myPicture = ImageIO.read(new File("images/agewar.jpg"));
			bigCard.setIcon(new ImageIcon(myPicture));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		bigCard.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	  if(!gc.getCardStack().empty()) {
		    		  gc.deSelectCard();
		    		  disableBlines();
		    	  }
		        }
		      });
	
		
	}
	
	private void initPlayers() {
		playerOne = new JPanel();
		p1 = new JLabel(new ImageIcon("images/p1.jpg"));
		playerTwo = new JPanel();
		p2 = new JLabel(new ImageIcon("images/p2.jpg"));
		
		JPanel addLabels1 = new JPanel();
		addLabels1.setLayout(new BoxLayout(addLabels1, BoxLayout.Y_AXIS));
		lbP1Name = new JLabel();
		lbP1Name.setText("Player 1");
		lbP1Name.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbP1Points = new JLabel("Points: 0");
		lbP1Points.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		btnStart1 = new JButton("My Turn");
		btnStart1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnStart2 = new JButton("My Turn");
		btnStart2.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnStart1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStart2.setEnabled(false);
				btnRollDice.setEnabled(true);
			
					gc.startNewTurn();
				
				
			}
		});
		btnStart2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStart1.setEnabled(false);
				btnRollDice.setEnabled(true);
			
					gc.startNewTurn();
				
			}
		});
		
		
		addLabels1.add(lbP1Name, CENTER_ALIGNMENT);
		addLabels1.add(Box.createRigidArea(new Dimension(0,15)));
		addLabels1.add(lbP1Points);
		addLabels1.add(Box.createRigidArea(new Dimension(0,30)));
		addLabels1.add(btnStart1);
		playerOne.add(p1);
		playerOne.add(addLabels1);

		JPanel addLabels2 = new JPanel();
		addLabels2.setLayout(new BoxLayout(addLabels2, BoxLayout.PAGE_AXIS));
		lbP2Name = new JLabel();
		lbP2Name.setText(" ");
		lbP2Name.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbP2Points = new JLabel("Points: 0");
		lbP2Points.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		playerTwo.add(addLabels2);
		addLabels2.add(lbP2Name);
		addLabels2.add(Box.createRigidArea(new Dimension(0,15)));
		addLabels2.add(lbP2Points);
		addLabels2.add(Box.createRigidArea(new Dimension(0,30)));
		addLabels2.add(btnStart2);
		playerTwo.add(p2);
	}
	
//	private void startNewTurn() {
//		gc.addDices();
//		updateDiceTable();
//	}
	
	/////////////////////////////////////////////
	
	@Override
	public void updateDiceTable() {
		diceModel.fireTableStructureChanged();
		diceTable.repaint();
		

	}

	@Override
	public void addedPlayers(String p1, String p2) {
		lbP1Name.setText(p1);
		lbP2Name.setText(p2);
		
	}

	@Override
	public void selectedCard(Icon i, String name) {
		bigCard.setIcon(new ImageIcon("images/cards/bigCard/" + name + ".png"));
		
	}
	
	@Override
	public void gameTurnStarted() {
		if(gc.getDiceListSize() == 0) {
			gc.addDices();
			updateDiceTable();
		}
	}

	@Override
	public void gameTurnEnded() {
		if(btnStart1.isEnabled()) {
			btnStart2.setEnabled(true);
			btnStart1.setEnabled(false);
		}else {
			btnStart1.setEnabled(true);
			btnStart2.setEnabled(false);
		}
		btnLine1.setEnabled(false);
		btnLine2.setEnabled(false);
		btnLine3.setEnabled(false);
		btnLine4.setEnabled(false);
//		diceModel.fireTableStructureChanged();
//		diceTable.repaint();
		
	}

	@Override
	public void deSelectedCard() {
		bigCard.setIcon(new ImageIcon("images/agewar.jpg"));
//		cardTable.repaint();
	}

	@Override
	public void enableBline(int line) {
		switch (line) {
		case 0:
			btnLine1.setEnabled(true);
			break;
		case 1:
			btnLine2.setEnabled(true);
			break;
		case 2:
			btnLine3.setEnabled(true);
			break;
		case 3:
			btnLine4.setEnabled(true);
			break;
		}
		
	}
	
	public void disableBlines() {
		btnLine1.setEnabled(false);
		btnLine2.setEnabled(false);
		btnLine3.setEnabled(false);
		btnLine4.setEnabled(false);
	}

	

}
