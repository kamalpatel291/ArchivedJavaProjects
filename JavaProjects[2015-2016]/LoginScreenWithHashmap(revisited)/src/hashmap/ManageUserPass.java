package hashmap;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ManageUserPass extends JFrame implements ActionListener {
		private LoginScreen ls;
		private BufferedReader readUserPass,readLoginNo;
		private String actualUserPass,userPassFile,actualLogin,loginNoFile = "C:/Users/kamal_000/Desktop/JavaLog/LoginNo.txt";
		private String userKeeper,passKeeper;
		private int loginNo;
		private JTable table;
		private JLabel lblCount;
		private DefaultTableModel model;
	
	public ManageUserPass() {
		// TODO Auto-generated constructor stub
		//JFrame frame = new JFrame();
		setTitle("User Pass Manager");
		setSize(420, 600);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel();
		lblWelcome.setText("Welcome Admin !");
		lblWelcome.setFont(new Font("Consolas",Font.BOLD,22));
		lblWelcome.setBounds(20, 0, 300, 40);
		add(lblWelcome);
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY,2), BorderFactory.createRaisedBevelBorder()));
		btnLogout.setFont(new Font("Cooper Black",Font.ITALIC,18));
		btnLogout.setActionCommand("logout");
		btnLogout.setBounds(250, 5, 130, 40);
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBackground(Color.WHITE);
		btnLogout.addActionListener(this);
		add(btnLogout);
		
		lblCount = new JLabel();
		lblCount.setFont(new Font("Constantia",Font.BOLD,20));
		lblCount.setBounds(15, 400, 380, 40);
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.darkGray,2), BorderFactory.createRaisedBevelBorder()));
		add(lblCount);
		
		Object [] columns = {"Username","Password"};
		model = new DefaultTableModel();
		
		table = new JTable();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setFont(new Font("Constantia",Font.BOLD,20));
		table.setRowHeight(32);
		table.enable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(15, 60, 380, 300);
		scroll.setViewportView(table);
		getContentPane().add(scroll);
		
		setVisible(true);

		
		printUserPass();
	}
	public String getUserKeeper(){
		
		return userKeeper;
	}
	public String getPassKeeper(){
		
		return passKeeper;
	}
	public int getLoginNo(){
	
		return loginNo;
	}
	
	public void setUserKeeper(String user){
		userKeeper = user;
	}
	public void setPassKeeper(String pass){
		passKeeper = pass;
	}
	public void setLoginNo(int num){
		loginNo = num;
	}
	
	public void printUserPass(){
		int X = 10,Y = 80;
		Object [] rows = new Object [3];

		
		try {
		readLoginNo = new BufferedReader(new FileReader (loginNoFile));
		while ((actualLogin = readLoginNo.readLine()) != null){
			setLoginNo(Integer.valueOf(actualLogin));
			
		}
		
		for(int x = 1; x <=  getLoginNo(); x++){
		userPassFile = "C:/Users/kamal_000/Desktop/JavaLog/UserPass"+String.valueOf(x)+".txt";
		readUserPass = new BufferedReader(new FileReader(userPassFile));
		while ((actualUserPass = readUserPass.readLine()) != null){
			String [] array = actualUserPass.split(" ");
			setUserKeeper(array[0]);
			setPassKeeper(array[1]);
		
		
		}
		System.out.println(getUserKeeper() + " " + getPassKeeper());
		rows[0] = getUserKeeper();
		rows[1] = "******";
		
		model.addRow(rows);
		Y+= 20;
		}
		lblCount.setText("Total Users : " + getLoginNo());

		
		
		
		
		
		
		}catch(IOException ex){
			
		}
	
	}
	public static void main(String[]args){
		ManageUserPass mup = new ManageUserPass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//repaint();
		if(e.getActionCommand().equals("logout")){
			LoginScreen ls = new LoginScreen();
			dispose();
		}
	}
}
 