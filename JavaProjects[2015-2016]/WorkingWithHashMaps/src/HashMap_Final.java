import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.JCheckBox;

public class HashMap_Final {

	private JFrame frame;
	private JTextField txtRUsername;
	private JPasswordField txtRPassword;
	private JPasswordField txtConfirmPass;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private Formatter x;
	private Formatter x2;
	private Scanner Z;
	private int g;
	private String i;
	private int y;
	private int zB = 0;
	private String zb;
	private int ZB;
	private PrintWriter writeUser, writePass;
	private HashMap <String, String> map = new HashMap<String,String>();
	private BufferedReader readUser,readPass;
	private String Username, Password;
	private String Voice16 = "kevin 16k", Voice8 = "kevin 8k";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashMap_Final window = new HashMap_Final();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HashMap_Final() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		System.setProperty("mbrola.base", "C:/mbrola");
		

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.LIGHT_GRAY);
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
		
		JLabel lblNewLabel = new JLabel("Incorrect Password !!");
		lblNewLabel.setFont(new Font("Andalus", Font.BOLD, 14));
		lblNewLabel.setBounds(452, 259, 163, 22);
		lblNewLabel.setVisible(false);
		panelLogin.add(lblNewLabel);
		
		JLabel lblLogoImage = new JLabel("");
		lblLogoImage.setBounds(37, 47, 250, 250);
		Image logoimage = new ImageIcon(this.getClass().getResource("/USER.png")).getImage();
		lblLogoImage.setIcon(new ImageIcon(logoimage));
		panelLogin.add(lblLogoImage);
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('X');
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
		panelLogin.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnRegister.setBounds(531, 301, 138, 31);
		panelLogin.add(btnRegister);
		
		JButton btnManage = new JButton("Manage Username/Password");
		btnManage.setFont(new Font("Andalus", Font.BOLD, 13));
		btnManage.setBounds(53, 324, 217, 26);
		panelLogin.add(btnManage);
		
		JCheckBox boxRememberMe = new JCheckBox("Remember Me");
		boxRememberMe.setFont(new Font("Constantia", Font.BOLD, 14));
		boxRememberMe.setBounds(485, 234, 138, 23);
		panelLogin.add(boxRememberMe);
		
		JPanel panelRegister = new JPanel();
		panelRegister.setBackground(Color.GRAY);
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
		
		JLabel lblRNewLabel = new JLabel("Password Doesn't Match !!");
		lblRNewLabel.setFont(new Font("Andalus", Font.BOLD, 14));
		lblRNewLabel.setBounds(452, 239, 200, 22);
		lblRNewLabel.setVisible(false);
		panelRegister.add(lblRNewLabel);
		
		JButton btnLoginScreen = new JButton("Login Screen");
		btnLoginScreen.setFont(new Font("Cooper Black", Font.PLAIN, 16));
		btnLoginScreen.setBounds(531, 301, 138, 31);
		panelRegister.add(btnLoginScreen);
		
		JButton btnRRegister = new JButton("Register");
		btnRRegister.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnRRegister.setBounds(383, 301, 138, 31);
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
		
		// Voice Parts
		System.setProperty("mbrola.base","C:\\Users\\kamal_000\\Desktop\\freetts-1.2.2-bin\\freetts-1.2\\mbrola");
	//	System.setProperty("com.sun.speech.freetts.audio.AudioPlayer.openFailDelayMs", "100");
	//	System.setProperty("com.sun.speech.freetts.audio.AudioPlayer.totalOpenFailDelayMs", "30000");
		Voice voice;
		VoiceManager vm = VoiceManager.getInstance();
		voice  = vm.getVoice("kevin16");
		voice.allocate();
		
		
		
		
		btnRRegister.addActionListener(new ActionListener(){
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				
				if (map.containsKey((txtUsername.getText())) && map.containsValue((txtPassword.getText()))){
							lblRNewLabel.setText("Username Already Exits !!");
							lblRNewLabel.setVisible(true);
							try {
								voice.speak(lblRNewLabel.getText());
								
							}catch(Exception ex) {}
				
			} else if (txtConfirmPass.getText().equals("") && txtRPassword.getText().equals("")){
					
							lblRNewLabel.setVisible(true);
					
				}else if (txtConfirmPass.getText().equals(txtRPassword.getText())) {
					lblRNewLabel.setText("Registration Successful !!");
					lblRNewLabel.setVisible(true);
					voice.speak(lblRNewLabel.getText());
				//	map1.add(txtRUsername.getText());
				//	map1.add(txtRPassword.getText());
				//	(txtRUsername.getText(), txtRPassword.getText());
					map.put(txtRUsername.getText(), txtRPassword.getText());
				
					try{
					//	zb = String.valueOf(zB);
						int g = 1;
						String i = String.valueOf(g);
						String fileName = "Username" + i + ".txt";
						x2 = new Formatter(fileName);
						x2.format("%S %S",txtRUsername.getText(),txtRPassword.getText());
						x2.close();
					}catch (Exception ex) {
						System.out.println("Failed to Create IMP.txt !!");
					} 
				/*	// Another way of putting it to .txt file
					g = 1;
					try {
					for( y=0;y<1;y++) {
						
						i = String.valueOf(g);
						String textUser = "Username #"+i+".txt";
						String textPass = "Password #"+ i +".txt";
						g++;
						writeUser = new PrintWriter(textUser);
						writeUser.println(txtRUsername.getText());
					//	writeUser.println(txtRPassword.getPassword());
						writeUser.close();
						
						writePass = new PrintWriter(textPass);
						writePass.println(txtRPassword.getPassword());
						writePass.close();
					//	x.format("%S %S %S %S", "Username: ",txtRUsername.getText(), "Password: ", txtRPassword.getText());
					//	x.close();
					}
					}catch (Exception ex){
						System.out.println("Failed to Create File !!!");
					}*/
			//		JOptionPane.showMessageDialog(null, map.entrySet(), "HashMap Values", JOptionPane.INFORMATION_MESSAGE);
		//
					

				}else if (map.containsKey((txtRUsername.getText()))) {
					lblRNewLabel.setVisible(true);
					try {
						voice.speak(lblRNewLabel.getText());
					
					}catch(Exception ex) {}
				}else {
					lblRNewLabel.setVisible(true);
					try {
						voice.speak(lblRNewLabel.getText());
					}catch(Exception ex) {}
				}
				
			}
		});
		
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			//	ZB = Integer.valueOf(zb);
				
				g= 1;
				i = String.valueOf(g);
				try{
					
					for (int z=0; z<1; z++){
						readUser = new BufferedReader(new FileReader("Username " + i + ".txt"));
						readPass = new BufferedReader(new FileReader("Password #" + i + ".txt"));
				 	
						while ((Username = readUser.readLine()) != null) {
							System.out.println(Username);
							
						}
						while((Password = readPass.readLine()) != null) {
							System.out.println(Password);
							
						}
						g++;
						
					System.out.println("User:" + Username + "" + "Password" + Password);		
					/*i = String.valueOf(g);
					Z = new Scanner (new File("Hello #"+i+".txt"));
					while(Z.hasNext()) {
						String username = Z.next();
						String Username = Z.next();
						String password = Z.next();
						String Password = Z.next();
						
						System.out.printf("%S %S %S %S \n",username,Username,password,Password);
				*/
						if ((Username.equals((txtUsername.getText())) || map.containsKey(txtUsername)) && (Password.equals((txtPassword.getText())) || map.containsValue(txtPassword.getText()))){
							
							try {
								JOptionPane.showMessageDialog(null, "Correct Password, Logging in...3", "Login", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Correct Password, Logging in...3");
								Thread.sleep(2500);
								JOptionPane.showMessageDialog(null, "Logging in...2", "Login", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Logging in...2");
								Thread.sleep(2500);
								JOptionPane.showMessageDialog(null, "Logging in...1", "Login", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Logging in...1");
								Thread.sleep(2500);
								JOptionPane.showMessageDialog(null, "Successfuly Logged In !!", "Login", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Successfuly Logged In !!");
								frame.dispose();
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else if (Username.equals((txtUsername.getText())) && !(Password.equals((txtPassword.getText())))) {
							
							lblNewLabel.setText("Incorrect Passowrd !!");
							lblNewLabel.setVisible(true);
							try {
								voice.speak(lblNewLabel.getText());
							}catch(Exception ex) {}
							
						}else if (!(Username.equals((txtUsername.getText()))) && Password.equals((txtPassword.getText()))) {
							
							lblNewLabel.setText("Incorrect Username !!");
							lblNewLabel.setVisible(true);
							try {
								voice.speak(lblNewLabel.getText());
							}catch(Exception ex) {}
							
						}else {
							
							lblNewLabel.setSize(240, 22);
							lblNewLabel.setText("Incorrect Username/Password !!");
							lblNewLabel.setVisible(true);
							try {
								voice.speak(lblNewLabel.getText());
							}catch(Exception ex) {}
						//	JOptionPane.showMessageDialog(null, "Wrong Username/Password", "Loginf", JOptionPane.INFORMATION_MESSAGE);
						
						}
					
					}
				}catch(Exception ex) {
					System.out.println("Couldn't Find The Requested File In DataBase !!");
				}
				
			
				
			}
		});
		
		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (boxRememberMe.isSelected() == true) {
					txtRUsername.setText("");
					txtRPassword.setText("");
					txtConfirmPass.setText("");
					lblNewLabel.setVisible(false);
					panelLogin.setVisible(false);
					panelRegister.setVisible(true);	
				}else {
					txtUsername.setText("");
					txtPassword.setText("");
					txtRUsername.setText("");
					txtRPassword.setText("");
					txtConfirmPass.setText("");
					panelLogin.setVisible(false);
					panelRegister.setVisible(true);
					
				}
				}
		});
		
		btnLoginScreen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(true);
				panelRegister.setVisible(false);
			}
		});
		
	}
}
