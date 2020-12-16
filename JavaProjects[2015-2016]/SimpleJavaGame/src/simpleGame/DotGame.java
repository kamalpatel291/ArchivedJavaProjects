package simpleGame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DotGame {

	private JFrame frame;
	private int y;
	private int x;
	private static boolean win = false;
	private static Random random = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DotGame window = new DotGame();
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
	public DotGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setBounds(112, 28, 46, 14);
		frame.getContentPane().add(lblHello);
		
		
		
	}
	public static void Loop(JFrame frame, JLabel lblHello) {
		do {
			int x = random.nextInt(frame.getWidth());
			
			int y = random.nextInt(frame.getHeight());
			
			lblHello.setBounds(x, y, 30, 30);
			try {
				Thread.sleep(5000);
			}catch (Exception e) {
				System.out.println("ERROR !");
			}
			//JOptionPane.showMessageDialog(null, "Hello");
		}while (win == false);
	}
}
