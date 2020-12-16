import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

public class HashMaps {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	public HashMap <String, String> map = new HashMap <String, String> ();

	/**
	 * Launch the application.
	 */
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashMaps window = new HashMaps();
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
	public HashMaps() {
		initialize();
	}

	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	public void initialize() {
		
		
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnLogin.setBounds(383, 301, 138, 31);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Cooper Black", Font.BOLD, 15));
		lblUsername.setBounds(379, 133, 96, 26);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cooper Black", Font.BOLD, 15));
		lblPassword.setBounds(379, 200, 89, 23);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Cooper Black", Font.BOLD, 15));
		txtUsername.setBounds(485, 131, 138, 31);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Cooper Black", Font.BOLD, 15));
		txtPassword.setBounds(485, 196, 138, 31);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblLogoImage = new JLabel("");
		lblLogoImage.setBounds(37, 47, 250, 250);
		frame.getContentPane().add(lblLogoImage);
		Image logoimage = new ImageIcon(this.getClass().getResource("/USER.png")).getImage();
		lblLogoImage.setIcon(new ImageIcon(logoimage));
		
		JLabel lblNewLabel = new JLabel("Incorrect Password !!");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Andalus", Font.BOLD, 14));
		lblNewLabel.setBounds(452, 239, 163, 22);
		lblNewLabel.setVisible(false);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnRegister.setBounds(531, 301, 138, 31);
		frame.getContentPane().add(btnRegister);
		
		JButton btnManage = new JButton("Manage Username/Password");
		btnManage.setFont(new Font("Andalus", Font.BOLD, 13));
		btnManage.setBounds(53, 324, 217, 26);
		frame.getContentPane().add(btnManage);
		
//		HashMapsFirst map = new HashMapsFirst();
	//	txtUsername.setText(map.map1.get(0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (map.containsKey((txtUsername.getText())) && map.containsValue((txtPassword.getText()))){
					
					
				 	JOptionPane.showMessageDialog(null, "Correct Password, Logged in...3", "Login", JOptionPane.INFORMATION_MESSAGE);
					try {
						Thread.sleep(1000);
						JOptionPane.showMessageDialog(null, "Logging in...2", "Login", JOptionPane.INFORMATION_MESSAGE);
						Thread.sleep(1000);
						JOptionPane.showMessageDialog(null, "Logging in...1", "Login", JOptionPane.INFORMATION_MESSAGE);
						Thread.sleep(1000);
						JOptionPane.showMessageDialog(null, "Successfuly Logged In !!", "Login", JOptionPane.INFORMATION_MESSAGE);
					
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else if (map.containsKey((txtUsername.getText())) && !(map.containsValue((txtPassword.getText())))) {
					lblNewLabel.setText("Incorrect Passowrd !!");
					lblNewLabel.setVisible(true);
					
				}else if (!(map.containsKey((txtUsername.getText()))) && map.containsValue((txtPassword.getText()))) {
					lblNewLabel.setText("Incorrect Username !!");
					lblNewLabel.setVisible(true);
					
				}else {
					lblNewLabel.setSize(240, 22);
					lblNewLabel.setText("Incorrect Username/Password !!");
					lblNewLabel.setVisible(true);
				//	JOptionPane.showMessageDialog(null, "Wrong Username/Password", "Loginf", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				HashMapsFirst mapfirst = new HashMapsFirst(map);
				mapfirst.main(map);
				
				frame.dispose();
			
				
			}
		});
		
		
	}
}
