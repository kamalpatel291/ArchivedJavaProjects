import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JButton;

public class LaunchGame implements KeyListener {

	private JFrame frame;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					LaunchGame window = new LaunchGame();
		
	}
	/**
	 * Create the application.
	 */
/*	public LaunchGame() {
		
		initialize();
		frame.addKeyListener(this);
	}*/

	/**
	 * Initialize the contents of the frame.
	 */
	private LaunchGame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		btnNewButton = new JButton("");
		btnNewButton.setBounds(168, 420, 20, 20);
		frame.getContentPane().add(btnNewButton);
		
		frame.addKeyListener(this);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		int y = btnNewButton.getY();
		
		int bounds = y-=5;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		 
	}
}
