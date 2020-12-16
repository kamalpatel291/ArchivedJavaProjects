import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;
import javax.swing.JPanel;

public class HashMapsFirst {

	private JFrame frame;
	private JTextField txtRUsername;
	private JPasswordField txtRPassword;
	private JPasswordField txtRConfirmPass;
//	public HashMap <String, String> map = new HashMap <String, String>();
	public ArrayList <String> map1 = new ArrayList <String> ();
 
	
	/**
	 * Launch the application.
	 */
	public static void main(HashMap <String, String> map){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashMapsFirst window = new HashMapsFirst(map);
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
	
	public HashMapsFirst(HashMap <String, String> map) {
		initialize(map);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param mapChecking1 
	 */
	public void initialize(HashMap <String, String> map) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtRUsername = new JTextField();
		txtRUsername.setFont(new Font("Consolas", Font.BOLD, 14));
		txtRUsername.setBounds(216, 36, 138, 31);
		frame.getContentPane().add(txtRUsername);
		txtRUsername.setColumns(10);
		
		txtRPassword = new JPasswordField();
		txtRPassword.setFont(new Font("Consolas", Font.BOLD, 14));
		txtRPassword.setBounds(216, 95, 138, 31);
		frame.getContentPane().add(txtRPassword);
		
		txtRConfirmPass = new JPasswordField();
		txtRConfirmPass.setFont(new Font("Consolas", Font.BOLD, 14));
		txtRConfirmPass.setBounds(216, 150, 138, 31);
		frame.getContentPane().add(txtRConfirmPass);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Cooper Black", Font.BOLD, 15));
		lblUsername.setBounds(74, 38, 106, 25);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Cooper Black", Font.BOLD, 15));
		lblConfirmPassword.setBounds(10, 152, 170, 25);
		frame.getContentPane().add(lblConfirmPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Cooper Black", Font.BOLD, 18));
		btnRegister.setBounds(45, 269, 170, 36);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cooper Black", Font.BOLD, 15));
		lblPassword.setBounds(74, 97, 98, 25);
		frame.getContentPane().add(lblPassword);
		
		JButton btnHome = new JButton("LoginScreen");
		btnHome.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		btnHome.setBounds(243, 270, 138, 36);
		frame.getContentPane().add(btnHome);
		
		JLabel lblIncorrectUsername = new JLabel("Username Already Exits !!");
		lblIncorrectUsername.setBackground(Color.LIGHT_GRAY);
		lblIncorrectUsername.setFont(new Font("Andalus", Font.PLAIN, 13));
		lblIncorrectUsername.setBounds(216, 70, 151, 12);
		frame.getContentPane().add(lblIncorrectUsername);
		lblIncorrectUsername.setVisible(false);
		
		JLabel lblIncorrectPassword = new JLabel("Password Doesn't Match !!");
		lblIncorrectPassword.setBackground(Color.LIGHT_GRAY);
		lblIncorrectPassword.setFont(new Font("Andalus", Font.PLAIN, 13));
		lblIncorrectPassword.setBounds(216, 182, 165, 25);
		lblIncorrectPassword.setVisible(false);
		frame.getContentPane().add(lblIncorrectPassword);
		 
		
		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (txtRConfirmPass.getText().equals(txtRPassword.getText())) {
					lblIncorrectPassword.setText("Registration Successful !!");
					lblIncorrectPassword.setVisible(true);
				//	map1.add(txtRUsername.getText());
				//	map1.add(txtRPassword.getText());
				//	(txtRUsername.getText(), txtRPassword.getText());
					map.put(txtRUsername.getText(), txtRPassword.getText());
			//		JOptionPane.showMessageDialog(null, map.entrySet(), "HashMap Values", JOptionPane.INFORMATION_MESSAGE);
		//
					

				}else if (map.containsKey((txtRUsername.getText()))) {
					lblIncorrectUsername.setVisible(true);
				}else {
					lblIncorrectPassword.setVisible(true);
				}
			}
		});
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				HashMaps hashmap = new HashMaps();
			
				hashmap.main(null);
				frame.dispose();
				
			}
		});
		
				
	}

}
