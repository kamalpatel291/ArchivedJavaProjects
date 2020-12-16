package gamemanager;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.border.TitledBorder;

import games.RockPaperScissor;
import hashmap.LoginScreen;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameManagerTest implements ActionListener,MouseListener,MouseMotionListener{

	private JFrame frame;
	private JButton btnNimGame,btnRPSGame,btnGame3,btnGame4,btnGame5,btnGame6;
	private String username;
	private int x,y,coins,loginKeeper;
	private LoginScreen ls;
	private JMenuItem jmiRename;
	private JPopupMenu popupMenu;
	private JLabel lblRPSGame,lblNimGame;
	
	protected BufferedReader userPassReader;
	protected BufferedReader loginNoReader;
	protected String userPassFile,passKeeper,userKeeper;
	protected String loginNoFile = "C:/Users/kamal_000/Desktop/JavaLog/loginNo.txt";
	protected String actualUserPass;
	protected String actualLoginNo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GameManagerTest window = new GameManagerTest("Player-1",0);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	

	/**
	 * Create the application.
	 */
	public GameManagerTest(String username,int coins) {
		initialize(username,coins);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(String username,int coins) {
		setUsername(username);
		setCoins(coins);
		
		frame = new JFrame();
		frame.setTitle("Game Manager");
		frame.setBounds(1368/4, 768/4, 700, 450);
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.addWindowListener(new WindowListener(){
			public void windowClosing(WindowEvent e){
				saveAllStuff();
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
	//nim game
		btnNimGame = new JButton();
		btnNimGame.setBounds(100, 100, 100, 100);
		btnNimGame.setIcon(new ImageIcon(this.getClass().getResource("/NimGame.jpg")));
		btnNimGame.setBorder(BorderFactory.createEmptyBorder());
		btnNimGame.addMouseListener(this);
	//	btnNimGame.addMouseMotionListener(this);
		frame.getContentPane().add(btnNimGame);
		
   //rock paper scissor	
		btnRPSGame = new JButton();
		btnRPSGame.setBounds(100, 250, 100, 100);
		btnRPSGame.setIcon(new ImageIcon(this.getClass().getResource("/RPSGame.jpg")));
		btnRPSGame.setBorder(BorderFactory.createEmptyBorder());
		btnRPSGame.addMouseListener(this);
		frame.getContentPane().add(btnRPSGame);
		
		btnGame3 = new JButton();
		btnGame3.setBounds(300, 100, 100, 100);
		btnGame3.setBorder(BorderFactory.createEmptyBorder());
		btnGame3.addMouseListener(this);
		frame.getContentPane().add(btnGame3);
		
		btnGame4 = new JButton();
		btnGame4.setBounds(300, 250, 100, 100);
		btnGame4.setBorder(BorderFactory.createEmptyBorder());
		btnGame4.addMouseListener(this);
		frame.getContentPane().add(btnGame4);
		
		btnGame5 = new JButton();
		btnGame5.setBounds(500, 100, 100, 100);
		btnGame5.setBorder(BorderFactory.createEmptyBorder());
		btnGame5.addMouseListener(this);
		frame.getContentPane().add(btnGame5);
		
		btnGame6 = new JButton();
		btnGame6.setBounds(500, 250, 100, 100);
		btnGame6.setBorder(BorderFactory.createEmptyBorder());
		btnGame6.addMouseListener(this);
		frame.getContentPane().add(btnGame6);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 684, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setActionCommand("exit");
		mntmExit.addActionListener(this);
		mnFile.add(mntmExit);
		
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setActionCommand("about");
		mntmAbout.addActionListener(this);
		mnHelp.add(mntmAbout);
		
		popupMenu = new JPopupMenu();
		popupMenu.add(jmiRename = new JMenuItem("Rename"));
		frame.getContentPane().add(popupMenu);
		
		lblNimGame = new JLabel("Nim Game");
		lblNimGame.setVerticalAlignment(SwingConstants.TOP);
		lblNimGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblNimGame.setBounds(100, 204, 100, 44);
		frame.getContentPane().add(lblNimGame);
		
		lblRPSGame = new JLabel("<html>Rock Paper Scissor<html>");
		lblRPSGame.setVerticalAlignment(SwingConstants.TOP);
		lblRPSGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblRPSGame.setBounds(100, 356, 100, 44);
		frame.getContentPane().add(lblRPSGame);
		
	}
	public void setCoins(int coins){
		this.coins = coins;
	}
	public int getCoins(){
		return coins;
	}
	public int getLoginNo(){
		return loginKeeper;
	}
	public void setLoginNo(int no){
		loginKeeper = no;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return username;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void saveAllStuff(){
		try{
			loginNoReader = new BufferedReader(new FileReader(loginNoFile));
			while((actualLoginNo = loginNoReader.readLine()) != null){
			//	System.out.println(actualLoginNo);
				setLoginNo(Integer.valueOf(actualLoginNo));
			}
		}catch(IOException ex){
			setLoginNo(0);
		}
		try{
			for (int x = 1; x<=getLoginNo();x++){

				userPassFile = "C:/Users/kamal_000/Desktop/JavaLog/UserPass"+String.valueOf(x)+".txt";
			
				userPassReader = new BufferedReader(new FileReader(userPassFile));	
			
				while((actualUserPass = userPassReader.readLine()) != null){
				String array[] = actualUserPass.split(" ");
				
					if(array[0].equals(getUsername())){
						setCoins(getCoins());
						
						PrintWriter writeUserPass = new PrintWriter(userPassFile);
						writeUserPass.println(getUsername() + " " + array[1] + " " + String.valueOf(getCoins()));
						writeUserPass.flush();
						break;
					}
				}
			}
		}catch(IOException ex){
			
		}
	}
//action listener	
	@Override
	public void actionPerformed(ActionEvent e){
	
		if(e.getActionCommand().equals("exit")){
			saveAllStuff();
			System.exit(0);
		}else if (e.getActionCommand().equals("about")){
		
		}
		
	}

//mouse motion listener
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}

//mouse listener
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String source = String.valueOf(e.getSource());
		
		if(e.getClickCount() == 2 && e.getButton() == e.BUTTON1){
		
			
		//replace nim game with game names	
			if(source.replace("NimGame", "").length() < source.length()){
					
			}
			else if(source.replace("RPSGame", "").length() < source.length()){
				RockPaperScissor rps = new RockPaperScissor(getUsername(),getCoins());
				frame.dispose();
			}
			else if(source.replace("NimGame", "").length() < source.length()){
			
			}
			else if(source.replace("NimGame", "").length() < source.length()){
			
			}
			else if(source.replace("NimGame", "").length() < source.length()){
			
			}
			else if(source.replace("NimGame", "").length() < source.length()){
			
			}
		}else if(e.getButton() == e.BUTTON3){
			if(source.replace("NimGame", "").length() < source.length()){
				
			}
			else if(source.replace("RPSGame", "").length() < source.length()){
				popupMenu.show(btnRPSGame, e.getX(), e.getY());
				jmiRename.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
					String name = lblRPSGame.getText().replaceAll("<html>", "");
					String renamed = (String)JOptionPane.showInputDialog(frame, "Enter A New Name For RockPaperScissor Game:","Rename",JOptionPane.PLAIN_MESSAGE,null,null,name);
				//	JOptionPane.showInputDialog(frame, , title, messageType, icon, selectionValues, initialSelectionValue)
					lblRPSGame.setText("<html>" + renamed + "<html>");
					}
				});
			}
			else if(source.replace("NimGame", "").length() < source.length()){
			
			}
			else if(source.replace("NimGame", "").length() < source.length()){
			
			}
			else if(source.replace("NimGame", "").length() < source.length()){
			
			}
			else if(source.replace("NimGame", "").length() < source.length()){
			
			}
			
			
			
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
