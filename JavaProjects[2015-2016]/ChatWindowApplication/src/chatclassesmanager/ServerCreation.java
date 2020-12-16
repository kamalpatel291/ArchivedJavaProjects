package chatclassesmanager;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;

public class ServerCreation extends JFrame {
	private JTextField userInputField;
	private JTextArea chatWindow;
	private ObjectInputStream userInput;
	private ObjectOutputStream userOutput;
	private ServerSocket server;
	private Socket connection;
	private ServerMainPage serverMP;
	
	public ServerCreation() {
		super("Chat Window");
		setSize(400,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		getContentPane().setLayout(null);
		
		userInputField = new JTextField();
		userInputField.setBounds(0, 325, 125, 100);
		userInputField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sendMessage(e.getActionCommand());
			}
		});
		
		chatWindow = new JTextArea();
		chatWindow.setBounds(0,0,400,325);
		chatWindow.setEditable(false);
		add(new JScrollPane(chatWindow));
		
		add(userInputField);
		add(chatWindow);
		
		setVisible(true);
		
	}
	//set up and runs the server
	public void setupAndRunServer(){
		try{
		server = new ServerSocket(2468,2);
		while(true){
			try{
				waitForConnection();
				setupInputOutputStreams();
				whileChatting();
			}catch(EOFException eofException){
				showMessage("\n Server Ended the Connection");
			}finally{
				closeStuff();
			}
			
		}
		}catch(IOException ioexception){
		
		}
		
	}
	
	//waits for the connection and when connected it displays the info for that connection
	public void waitForConnection() throws IOException { 
		showMessage("User is Offline..Waiting for Connection...!! \n");
		connection = server.accept();
		showMessage("Now Connected to "+ connection.getInetAddress().getHostName());
		
	}
	
	//created input and output streams that sends and receives data
	public void setupInputOutputStreams() throws IOException {
		userOutput = new ObjectOutputStream(connection.getOutputStream());
		userOutput.flush();
		
		userInput = new ObjectInputStream(connection.getInputStream());
		showMessage("\n\n Streams are now Setup! \n");
	
	}
	
	//during the conversation
	public void whileChatting() throws IOException {
		String message = "You are now Connected !";
		sendMessage(message);
		ableToType(true);
		do{
			try{
				message = (String) userInput.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException classnotfoundexception){
				showMessage(" \n @#$%^&*&*^%()@(#$*% IDK What you are typing");
			}
		}while(!(message.equals("Client - END")));
	}
	
	//close streams and all stuff
	public void closeStuff() {
		sendMessage("Closing Connection...!");
		ableToType(false);
		try{
			userInput.close();
			userOutput.close();
			connection.close();
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	//send message to other user or client
	public void sendMessage(String textMessage){
		try{
			userOutput.writeObject("SERVER - " + textMessage);
			userOutput.flush();
			showMessage("\nSERVER - " + textMessage);
		}catch(IOException ioException){
			chatWindow.append("\n Error: Failed To Send The Message To The User!!");
		}
	}
	
	//updates chatWindow
	public void showMessage(final String text){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				chatWindow.append(text);
			}
		});
	}
	
	//set the userInputField enable to true or false depending on the situation
	public void ableToType(final boolean tOF){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				userInputField.setEditable(tOF);
			}
		});
	}
}
