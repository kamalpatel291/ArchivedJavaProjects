package chatclassesmanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ServerMainPage extends JFrame  {
	private JTextField userInput;
	private JButton btnStart;
	private ServerCreation server;
		
	public JTextField getUserInput() {
		return userInput;
	}

	public void setUserInput(JTextField userInput) {
		this.userInput = userInput;
	}
	
	public ServerMainPage(){
		super("Start Page");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.CYAN);
		
		btnStart = new JButton("Start");
		btnStart.setFont(new Font ("CooperBlack", Font.BOLD,20));
		btnStart.setBounds(200,200,100,40);
		btnStart.setBackground(Color.LIGHT_GRAY);
		
		userInput = new JTextField();
		userInput.setFont(new Font ("Consolas", Font.BOLD, 16));
		userInput.setBounds(100, 150, 300, 40);
		
		add(btnStart);
		add(userInput);
		
		setVisible(true);
		
		btnStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!(userInput.getText().equals(""))){
					server = new ServerCreation();
				}
			}
		});
		
	}



	public static void main(String[] args) {
		ServerMainPage main = new ServerMainPage();
	}

}
