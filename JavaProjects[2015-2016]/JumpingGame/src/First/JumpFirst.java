package First;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class JumpFirst implements ActionListener {
	public static JumpFirst jumpf;
	public JFrame jframe;
	public JumpThird third;
	public int WIDTH = 400, HEIGHT = 200;
	public JumpFirst() {
		third = new JumpThird();
		jframe = new JFrame();
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setVisible(true);
	//	jframe.setResizable(false);
		jframe.setTitle("Game :D (Propably NOT)");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		third.repaint();
	}
	
	public void repaint(Graphics g) {
		g.setColor(Color.blue.brighter());
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setFont(new Font ("Cooper Black", Font.BOLD, 15));
		g.setColor(Color.BLACK.brighter());
		g.drawString(jframe.getTitle(), 100, 0);
		
	}
	
	public static void main (String[]args) {
		JumpFirst first = new JumpFirst();
	}
	
}