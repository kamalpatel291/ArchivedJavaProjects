package hashmap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gamemanager.GameManagerTest;

import java.io.*;

public class LoginScreen implements ActionListener{
	private JFrame frame;
	private JTextField txtRUsername,txtUsername;
	private JPasswordField txtRPassword,txtConfirmPass,txtPassword;
	private JCheckBox boxRememberMe;
	private JLabel lblNewLabel,lblRNewLabel;
	private JPanel panelLogin,panelRegister;
	private int loginKeeper,counter = 0,coins;
	protected BufferedReader userPassReader;
	protected BufferedReader loginNoReader;
	private String passKeeper,userKeeper;
	protected String userPassFile;
	protected String loginNoFile = "C:/Users/kamal_000/Desktop/JavaLog/loginNo.txt";
	protected String actualUserPass;
	protected String actualLoginNo;
	
	
	public LoginScreen() {
		frame = new JFrame();
		frame.setTitle("Login Panel");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(1366/4,768/4, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(false);
		frame.getContentPane().setLayout(null);		

		panelLogin = new JPanel();
		panelLogin.setBackground(Color.RED);
		panelLogin.setForeground(Color.GRAY);
		panelLogin.setBounds(0, 0, 684, 361);
		frame.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Cooper Black", Font.BOLD, 15));
		lblUsername.setBounds(379, 133, 96, 26);
		panelLogin.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cooper Black", Font.BOLD, 15));
		lblPassword.setBounds(379, 200, 89, 26);
		panelLogin.add(lblPassword);
		
		lblNewLabel = new JLabel("Incorrect Password !!");
		lblNewLabel.setFont(new Font("Andalus", Font.BOLD, 14));
		lblNewLabel.setBounds(432, 259, 250, 22);
		lblNewLabel.setVisible(false);
		panelLogin.add(lblNewLabel);
		
		JLabel lblLogoImage = new JLabel("");
		lblLogoImage.setBounds(37, 47, 250, 250);
		Image logoimage = new ImageIcon(this.getClass().getResource("/USER.png")).getImage();
		lblLogoImage.setIcon(new ImageIcon(logoimage));
		panelLogin.add(lblLogoImage);
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setFont(new Font("Constantia", Font.BOLD, 15));
		txtPassword.setBounds(485, 196, 138, 31);
		panelLogin.add(txtPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Constantia", Font.BOLD, 15));
		txtUsername.setBounds(485, 131, 138, 31);
		panelLogin.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnLogin.setBounds(383, 301, 138, 31);
		btnLogin.setActionCommand("login");
		btnLogin.addActionListener(this);
		panelLogin.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnRegister.setBounds(531, 301, 138, 31);
		btnRegister.setActionCommand("register");
		btnRegister.addActionListener(this);
		panelLogin.add(btnRegister);
		
		JButton btnManage = new JButton("Manage Username/Password");
		btnManage.setFont(new Font("Andalus", Font.BOLD, 13));
		btnManage.setBounds(53, 324, 217, 26);
		btnManage.setActionCommand("manage");
		btnManage.addActionListener(this);
		panelLogin.add(btnManage);
		
		boxRememberMe = new JCheckBox("Remember Me");
		boxRememberMe.setFont(new Font("Constantia", Font.BOLD, 14));
		boxRememberMe.setBounds(485, 234, 138, 23);
		panelLogin.add(boxRememberMe);
		
		panelRegister = new JPanel();
		panelRegister.setBackground(Color.YELLOW);
		panelRegister.setBounds(0, 0, 684, 361);
		frame.getContentPane().add(panelRegister);
		panelRegister.setVisible(false);
		panelRegister.setLayout(null);
		
		JLabel lblRLogoImage = new JLabel("");
		lblRLogoImage.setBounds(37, 47, 250, 250);
		Image logoimageR = new ImageIcon(this.getClass().getResource("/USER.png")).getImage();
		lblRLogoImage.setIcon(new ImageIcon(logoimageR));
		panelRegister.add(lblRLogoImage);
		
		txtRUsername = new JTextField();
		txtRUsername.setFont(new Font("Constantia", Font.BOLD, 15));
		txtRUsername.setBounds(485, 100, 138, 31);
		panelRegister.add(txtRUsername);
		txtRUsername.setColumns(10);
		
		JLabel lblRUsername = new JLabel("Username");
		lblRUsername.setFont(new Font("Cooper Black", Font.BOLD, 15));
		lblRUsername.setBounds(379, 100, 96, 23);
		panelRegister.add(lblRUsername);
		
		JLabel lblRPassword = new JLabel("Password");
		lblRPassword.setFont(new Font("Cooper Black", Font.BOLD, 15));
		lblRPassword.setBounds(379, 150, 89, 23);
		panelRegister.add(lblRPassword);
		
		lblRNewLabel = new JLabel("Password Doesn't Match !!");
		lblRNewLabel.setFont(new Font("Andalus", Font.BOLD, 14));
		lblRNewLabel.setBounds(432, 239, 250, 22);
		lblRNewLabel.setVisible(false);
		panelRegister.add(lblRNewLabel);
		
		JButton btnLoginScreen = new JButton("Login Screen");
		btnLoginScreen.setFont(new Font("Cooper Black", Font.PLAIN, 16));
		btnLoginScreen.setBounds(531, 301, 138, 31);
		btnLoginScreen.setActionCommand("loginscreen");
		btnLoginScreen.addActionListener(this);
		panelRegister.add(btnLoginScreen);
		
		JButton btnRRegister = new JButton("Register");
		btnRRegister.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnRRegister.setBounds(383, 301, 138, 31);
		btnRRegister.setActionCommand("rregister");
		btnRRegister.addActionListener(this);
		panelRegister.add(btnRRegister);
		
		txtRPassword = new JPasswordField();
		txtRPassword.setEchoChar('X');
		txtRPassword.setFont(new Font("Constantia", Font.BOLD, 15));
		txtRPassword.setBounds(485, 150, 138, 31);
		panelRegister.add(txtRPassword);
		
		JLabel lblConfirmPass = new JLabel("Confirm Password");
		lblConfirmPass.setFont(new Font("Cooper Black", Font.BOLD, 15));
		lblConfirmPass.setBounds(305, 200, 178, 23);
		panelRegister.add(lblConfirmPass);
		
		txtConfirmPass = new JPasswordField();
		txtConfirmPass.setEchoChar('X');
		txtConfirmPass.setFont(new Font("Constantia", Font.BOLD, 15));
		txtConfirmPass.setBounds(485, 200, 138, 31);
		panelRegister.add(txtConfirmPass);
		
		
		frame.setVisible(true);
	}
	public int getLoginNo(){
		return loginKeeper;
	}
	public void setLoginNo(int no){
		loginKeeper = no;
	}
	public String getUserKeeper(){
		return userKeeper;
	}
	public void setUserKeeper(String user){
		userKeeper = user;
	}
	public String getPassKeeper(){
		return passKeeper;
	}
	public void setPassKeeper(String pass){
		passKeeper = pass;
	}
	public void setCoins(int coins){
		this.coins = coins;
	}
	public int getCoins(){
		return coins;
	}
	public static void main(String[] args) {
		
		LoginScreen ls = new LoginScreen();

	}
	
	@Override
	public void actionPerformed(ActionEvent e){
	String	ac = e.getActionCommand();
		if(ac.equals("register")){
			frame.setTitle("Register Panel");
			if(!(boxRememberMe.isSelected())){
				txtUsername.setText("");
				txtPassword.setText("");
			}
			
			panelLogin.setVisible(false);
			panelRegister.setVisible(true);
			
		}else if(ac.equals("login")){
			lblNewLabel.setVisible(false);
			lblNewLabel.setText("");
			
			counter = 0;
			try {
				loginNoReader = new BufferedReader(new FileReader(loginNoFile));
				while((actualLoginNo = loginNoReader.readLine()) != null){
					setLoginNo(Integer.valueOf(actualLoginNo));
				}
				for (int x = 1; x<=getLoginNo();x++){
					

					userPassFile = "C:/Users/kamal_000/Desktop/JavaLog/UserPass"+String.valueOf(x)+".txt";
				//	passFile = "C:/Users/kamal_000/Desktop/JavaLog/pass"+String.valueOf(x)+".txt";
					
					userPassReader = new BufferedReader(new FileReader(userPassFile));	
				//	passReader = new BufferedReader(new FileReader(passFile));
					
					while((actualUserPass = userPassReader.readLine()) != null){
						String array[] = actualUserPass.split(" ");
						setUserKeeper(array[0]);
						setPassKeeper(array[1]);
						setCoins(Integer.valueOf(array[2]));
					}
					
					
					if(txtPassword.getText().equals(getPassKeeper()) && txtUsername.getText().equals(getUserKeeper())){
						
						System.out.println("\t \tWorked! :D ");
						GameManagerTest gmt = new GameManagerTest(txtUsername.getText(),getCoins());
						frame.dispose();
						break;
					}else if(x==getLoginNo()) {
						lblNewLabel.setVisible(true);
						lblNewLabel.setText("Username/Password Doesn't Match !");
					}
					
				}
				
		
				
				
				
				
			} catch (FileNotFoundException e1 ) {
				// TODO Auto-generated catch block
				lblNewLabel.setVisible(true);
				lblNewLabel.setText("Error ! Login Doesn't Exist !");
				//e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if(ac.equals("rregister")){
			lblRNewLabel.setVisible(false);
			lblRNewLabel.setText("");
			
			try{
				loginNoReader = new BufferedReader(new FileReader(loginNoFile));
				while((actualLoginNo = loginNoReader.readLine()) != null){
					setLoginNo(Integer.valueOf(actualLoginNo));
				}
			}catch(IOException ex){
				setLoginNo(0);
			}
		if (txtRPassword.getText().equals(txtConfirmPass.getText()) && !(txtRPassword.getText().equals("")
				|| txtConfirmPass.getText().equals("") || txtRUsername.getText().equals(""))){
			try{
				for (int x = 1; x<=getLoginNo();x++){

					userPassFile = "C:/Users/kamal_000/Desktop/JavaLog/UserPass"+String.valueOf(x)+".txt";
				
					userPassReader = new BufferedReader(new FileReader(userPassFile));	
				
					while((actualUserPass = userPassReader.readLine()) != null){
					String array[] = actualUserPass.split(" ");
					
					if(array[0].equals(txtRUsername.getText())){
					lblRNewLabel.setText("Username Already Exits! ");
					lblRNewLabel.setVisible(true);
					
					counter = 1;
					break;
		
					}else{
						counter = 0;
					}
					}
					
				}
			}catch(IOException ex){
				counter = 0;
			}
			
		if(counter != 1){
			try {
				PrintWriter writeUserPass = new PrintWriter(new File("C:/Users/kamal_000/Desktop/JavaLog/UserPass"+String.valueOf(getLoginNo()+1)+".txt"));
				writeUserPass.println(txtRUsername.getText() + " " + txtRPassword.getText() + " " + 0);
				writeUserPass.flush();
				
				PrintWriter writeLoginNo = new PrintWriter(new File(loginNoFile));
				writeLoginNo.println(getLoginNo()+1);
				writeLoginNo.flush();
				
				lblRNewLabel.setVisible(true);
				lblRNewLabel.setText("Registration Successful !");
				JOptionPane.showMessageDialog(null, "Registration Successful !","Registration",JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
		//	lblRNewLabel.setVisible(true);
		
		}
		}else{
			if(txtRUsername.getText().equals("") || txtRPassword.getText().equals("") || txtConfirmPass.getText().equals("")){
				lblRNewLabel.setText("Please Fill In the Blank textbox(es) !");
				lblRNewLabel.setVisible(true);
			}else{
				lblRNewLabel.setText("Password Doesn't Match !");
				lblRNewLabel.setVisible(true);
			}
			
		}
		
		
		}else if(ac.equals("loginscreen")){
			frame.setTitle("Login Panel");
			txtRUsername.setText("");
			txtRPassword.setText("");
			txtConfirmPass.setText("");
			panelRegister.setVisible(false);
			panelLogin.setVisible(true);
		}else if(ac.equals("manage")){
			if(txtPassword.getText().equals("nimda") && txtUsername.getText().equals("admin")){
					System.out.println("\t \tAdmin is in :D");
					ManageUserPass mup = new ManageUserPass();
					frame.dispose();
					
			}else{
				JOptionPane.showMessageDialog(null, "Access Denied ! Only Admin is Allowed !","Access Denied",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
