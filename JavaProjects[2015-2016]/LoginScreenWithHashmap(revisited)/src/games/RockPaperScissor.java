package games;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gamemanager.GameManagerTest;

public class RockPaperScissor implements ActionListener {
	private JTextArea output;
	private JLabel lblScore;
	private JButton rock, paper, scissor;
	private static JFrame frame;
	private String outputText, playerName;
	private int winCountComputer, winCountPlayer,coins,coinsCounter;
	private RockPaperScissorComp comp;
	private final int WIDTH = 460, HEIGHT = 461;
	private boolean gameOver = false;
	
	public RockPaperScissor(String username,int coins) {
		playerName = username;
		this.coins = coins;
		outputText = "";	
			frame = new JFrame();
			//frame.setResizable(false);
			frame.setSize(WIDTH, HEIGHT);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setDefaultLookAndFeelDecorated(true);
			frame.getContentPane().setLayout(null);
			frame.addWindowListener(new WindowListener(){

				@Override
				public void windowActivated(WindowEvent e) {
					
				}

				@Override
				public void windowClosed(WindowEvent e) {
					
				}

				@Override
				public void windowClosing(WindowEvent e) {
					if(gameOver = true){
						JOptionPane.showMessageDialog(frame, "You Are Forfeiting The Game... \n (no coins will be awarded)", "Forefiet", JOptionPane.WARNING_MESSAGE);
					}
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		
			output = new JTextArea();
			output.setText("\n\nWelcome To Rock Paper Scissor Game !! \n" + "First To Win the 10 Rounds Wins The Match !! ");
			output.setFont(new Font("Consolas", Font.BOLD, 14));
			output.setBounds(0,61,390,300);
			output.setEditable(false);
			
			JScrollPane scroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setBounds(0, 61, 440, 300);
			
			JButton btnBack = new JButton("Back");
			btnBack.setBounds(0, 21, 100, 40);
			btnBack.setActionCommand("back");
			btnBack.addActionListener(this);
			btnBack.setBorder(BorderFactory.createRaisedBevelBorder());
			btnBack.setFont(new Font("CooperBlack",Font.BOLD,22));
			
			JLabel lblCoin = new JLabel();
			lblCoin.setIcon(new ImageIcon(this.getClass().getResource("/coins2.jpg")));
			lblCoin.setBounds(280, 21, 40, 40);
			
			lblScore = new JLabel();
			lblScore.setBounds(330, 21, 100, 40);
			lblScore.setForeground(Color.yellow);
			lblScore.setFont(new Font("Andalus",Font.BOLD,22));
			lblScore.setText(String.valueOf(coins));
			
			
			
			rock = new JButton("Rock");
			rock.setBounds(5, 361, 100, 50);
			rock.addActionListener(this);
			rock.setActionCommand("rock");
			
			paper = new JButton("Paper");
			paper.setBounds(175, 361, 100, 50);
			paper.addActionListener(this);
			paper.setActionCommand("paper");
			
			scissor = new JButton("Scissor");
			scissor.setBounds(330, 361, 100, 50);
			scissor.addActionListener(this);
			scissor.setActionCommand("scissor");
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 700, 21);
			frame.getContentPane().add(menuBar);
			
			JMenu mnFile = new JMenu("File");
			menuBar.add(mnFile);
			
			JMenuItem mntmExit = new JMenuItem("Exit");
			mnFile.add(mntmExit);
			mntmExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
			
			JMenu mnHelp = new JMenu("Help");
			menuBar.add(mnHelp);
			
			JMenuItem mntmAbout = new JMenuItem("About");
			mnHelp.add(mntmAbout);
			
			frame.getContentPane().add(scroll);
			frame.add(rock);
			frame.add(paper);
			frame.add(scissor);
			frame.add(lblScore);
			frame.add(btnBack);
			frame.add(lblCoin);
			frame.setVisible(true);
			
			
		comp = new RockPaperScissorComp();	
			
		}
		
	public int updateCoins(int coins){
		this.coins = this.coins + coins;
		return this.coins;
	}

		
		public void RockPaperScissorMethod(String compChoice, String playerChoice, String text) {
		
			if (winCountPlayer <= 10 || winCountComputer <= 10) {
			if (compChoice.equals(playerChoice)) {
				outputText = text + "Nobody Won This Round, This Round Is Draw !! \n";
				output.setText(outputText);
				
			}else if (compChoice.equals("Rock") && playerChoice.equals("Scissor") || compChoice.equals("Paper") && playerChoice.equals("Rock") || 
					compChoice.equals("Scissor") && playerChoice.equals("Paper")){
				outputText = text + "Computer Won This Round !! Better Luck Next Time !! \n ";
				output.setText(outputText);
				winCountComputer += 1;
				
			}else {
				outputText = text +  "Congratulation !! You Won This Round !! \n";
				output.setText(outputText);
				winCountPlayer += 1;
			}
			
			} else {
				 if (winCountPlayer > winCountComputer){
				//	renderer.repaint();
					 gameOver = true;
					JOptionPane.showMessageDialog(frame, "Player Wins !!", "RPSGame-Player Win", JOptionPane.INFORMATION_MESSAGE);
					coinsCounter = 10;
					int coinsShow = coins + 10;
					lblScore.setText(String.valueOf(coinsShow));
				 }else {
					 gameOver = true;
					JOptionPane.showMessageDialog(frame, "Computer Wins !!", "RPSGame-Computer Win", JOptionPane.INFORMATION_MESSAGE);
					coinsCounter = 5;
					int coinsShow = coins + 5;
					lblScore.setText(String.valueOf(coinsShow));
					//	renderer.repaint();
				 }
			 }
		
		
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			String playerChoice = "";
			String computerChoice = comp.computer();
			
			if(e.getActionCommand().equals("rock")){
				playerChoice = rock.getText();
			}else if (e.getActionCommand().equals("paper")){
				playerChoice = paper.getText();	
			}else if (e.getActionCommand().equals("scissor")) {
				playerChoice = scissor.getText();	
			}else if(e.getActionCommand().equals("exit")){
				JOptionPane.showMessageDialog(frame, "You Are Forfeiting The Game... \n (no coins will be awarded)", "Forefiet", JOptionPane.WARNING_MESSAGE);
			}else {
				int coins = updateCoins(coinsCounter);
				GameManagerTest gmt = new GameManagerTest(playerName,coins);
				gameOver = true;
				frame.dispose();
				
			}
			
			if(!(gameOver)){
			
			outputText = outputText + "\n" + playerName + " picked " + playerChoice + "\n";
			outputText = outputText + "Computer picked " + computerChoice + "\n";
		//	renderer.repaint();
			RockPaperScissorMethod(computerChoice,playerChoice, outputText);
			
			}
		}
	}
